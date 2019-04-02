import io.vertx.core.Future;
import io.vertx.rxjava.core.AbstractVerticle;
import io.vertx.rxjava.core.http.HttpServer;

public class MyRxVerticle extends AbstractVerticle {

    @Override
    public void start(Future<Void> startFuture) throws Exception {
        HttpServer httpServer = vertx.createHttpServer();
        httpServer.requestStream().toObservable()
                .subscribe(req ->
                        req.response()
                            .end("RX from" + Thread.currentThread().getName()));
        httpServer.rxListen(8080).subscribe();
    }
}
