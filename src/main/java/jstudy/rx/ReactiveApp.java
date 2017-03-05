package jstudy.rx;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;

public class ReactiveApp {

    public static void main(String... args) {
        System.out.println("rx...");

        Observable<String> myObservable = Observable.create((ObservableEmitter<String> sub) -> {
                    sub.onNext("Hello next");
                    sub.onComplete();
                }
        );
    }
}
