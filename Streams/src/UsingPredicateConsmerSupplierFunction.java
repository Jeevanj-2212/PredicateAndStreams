import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class UsingPredicateConsmerSupplierFunction {
    public static void main(String[] args) {
        List<User> users = new ArrayList<>();
        users.add(new User(1, "John", 18));
        users.add(new User(2, "Peter", 40));
        users.add(new User(3, "Ken", 22));
        users.add(new User(4, "A", 25));
        Predicate<User> condition = x-> x.getAge()>18 && x.getName().length()>1;
        Function<User,String> formatter = x-> "UserName "+x.getName()+ " Age "+x.getAge();
        Consumer<String> print = x->System.out.println(x);
        Supplier<String> err = ()->"No User Found ";
        boolean found = false;

        for(User user:users){
            if(condition.test(user)) {
                String res = formatter.apply(user);
                print.accept(res);
                found = true;
            }
        }
        if(!found){
            print.accept(err.get());
        }

    }
}
