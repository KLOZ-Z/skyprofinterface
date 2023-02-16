public class Main {
    public interface Predicate<T>{
        boolean test(T t);
    }

    public interface Predictatelmd{
        boolean test(int t);
    }

    public interface Consumer<T>{
        void accept(T t);
    }

    public interface Consumerlmd{
        void accept(String t);
    }

    public interface Function<T,R>{
        R apply(T t);
    }

    public interface Functionlmd{
        Long apply(Double t);
    }

    public interface Supplier<T>{
        T get();
    }
    public interface Supplierlmd{
        Integer get();
    }


    public static void main(String[] args) {
        int testNumber = 10;
        String testString = "Имя";
        double testNumber2 = 2.1;
        Predicate<Integer> predicate = new Predicate<Integer>() {
            @Override
            public boolean test(Integer o) {
                if(o > 0){
                    return true;
                }
                else return false;
            }
        };

        Predictatelmd obj1 = (a -> {
            if(a>0){
                return true;
            }
            else return false;
        });

        Consumer<String> consumer = new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println("Привет, "+s);
            }
        };

        Consumerlmd obj2 = (s -> System.out.println("Привет, "+ s));

        Function<Double, Long> function = new Function<Double, Long>() {
            @Override
            public Long apply(Double aDouble) {
                return aDouble.longValue();
            }
        };

        Functionlmd obj3 = (Double::longValue);

        Supplier<Integer> supplier = new Supplier<Integer>() {
            @Override
            public Integer get() {
                return (int) (Math.random() * ((100) + 1));
            }
        };

        Supplierlmd obj4 = (() -> (int) (Math.random() * ((100) + 1)));

        if (predicate.test(testNumber)){
            System.out.println("Число положительное");
        }
        consumer.accept(testString);
        System.out.println(function.apply(testNumber2));
        System.out.println(supplier.get());

        System.out.println("\nчерез лямбду");
        if (obj1.test(testNumber)){
            System.out.println("Число положительное");
        }
        obj2.accept(testString);
        System.out.println(obj3.apply(testNumber2));
        System.out.println(obj4.get());
    }
}