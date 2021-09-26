package threads;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Scheduler;
import reactor.core.scheduler.Schedulers;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.*;
import java.util.stream.Stream;

public class MainReport {
    public static Date filterDate;

    static {
        try {
            filterDate = new SimpleDateFormat("y-M-d H:m:s").parse("2021-7-1 00:00:00");
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws ParseException, ExecutionException, InterruptedException {

        ArrayList<Account> arrayList = new ArrayList<>();
        arrayList.add(new Account(1, "RUB", new SimpleDateFormat("y-M-d H:m:s").parse("2021-6-1 10:00:00")));
        arrayList.add(new Account(1, "RUB", new SimpleDateFormat("y-M-d H:m:s").parse("2021-7-1 10:00:00")));
        arrayList.add(new Account(1, "RUB", new SimpleDateFormat("y-M-d H:m:s").parse("2021-8-1 10:00:00")));
        arrayList.add(new Account(1, "RUB", new SimpleDateFormat("y-M-d H:m:s").parse("2021-9-1 10:00:00")));
        Customer customer = new Customer((short) 18, "Ivanov", arrayList);

        ArrayList<Account> arrayList01 = new ArrayList<>();
        arrayList01.add(new Account(1, "RUB", new SimpleDateFormat("y-M-d H:m:s").parse("2021-6-1 10:00:00")));
        arrayList01.add(new Account(1, "RUB", new SimpleDateFormat("y-M-d H:m:s").parse("2021-7-1 10:00:00")));
        arrayList01.add(new Account(1, "RUB", new SimpleDateFormat("y-M-d H:m:s").parse("2021-8-1 10:00:00")));
        arrayList01.add(new Account(1, "RUB", new SimpleDateFormat("y-M-d H:m:s").parse("2021-9-1 10:00:00")));
        Customer customer01 = new Customer((short) 28, "Ivanov", arrayList01);

        ArrayList<Account> arrayList02 = new ArrayList<>();
        arrayList02.add(new Account(1, "RUB", new SimpleDateFormat("y-M-d H:m:s").parse("2021-6-1 10:00:00")));
        arrayList02.add(new Account(1, "RUB", new SimpleDateFormat("y-M-d H:m:s").parse("2021-7-1 10:00:00")));
        arrayList02.add(new Account(1, "RUB", new SimpleDateFormat("y-M-d H:m:s").parse("2021-8-1 10:00:00")));
        arrayList02.add(new Account(1, "RUB", new SimpleDateFormat("y-M-d H:m:s").parse("2021-9-1 10:00:00")));
        Customer customer02 = new Customer((short) 38, "Ivanov", arrayList02);

        MainReport test = new MainReport();
        int result = test.getTotalsWithCompletableFuture(Arrays.asList(customer, customer01, customer02).stream());
        System.out.println(result);
        result = test.getTotalsWithReact(Arrays.asList(customer, customer01, customer02).stream());
        System.out.println(result);

    }

    public int getTotalsWithCompletableFuture(Stream<Customer> stream) throws ExecutionException, InterruptedException {
//        Executor executor = Executors.newFixedThreadPool(10);
        CompletableFuture<Integer> future = CompletableFuture.supplyAsync(() -> {
            return stream.filter(a -> a.getAge() >= 18 && a.getAge() <= 30).
                    map(Customer::getArrayList).
                    flatMap(List::stream).
                    filter(d -> d.getCreateDate().after(filterDate)).map(s -> s.getSum()).reduce(0, (x, y) -> x + y);
        });
        return future.get();
    }
    public int getTotalsWithReact(Stream<Customer> stream){
        ArrayList<Integer> result = new ArrayList<>();
        Mono<Integer> flux = Mono.just(stream.filter(a -> a.getAge() >= 18 && a.getAge() <= 30).
                map(Customer::getArrayList).
                flatMap(List::stream).
                filter(d -> d.getCreateDate().after(filterDate)).
                map(s -> s.getSum()).reduce(0, (x, y) -> x + y)
        );

        flux.subscribe(result::add);
        return result.get(0);
    }
}

