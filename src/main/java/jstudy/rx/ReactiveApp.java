package jstudy.rx;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;

public class ReactiveApp {

    public static void main(String... args) {
        System.out.println("rx...");

        Observable<String> myObservable = Observable.create(
                new ObservableOnSubscribe<String>() {
                    @Override
                    public void subscribe(ObservableEmitter<String> sub) {
                        sub.onNext("Hello next");
                        sub.onComplete();
                    }
                }
        );
    }
}
