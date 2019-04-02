import io.vertx.core.AbstractVerticle;
import io.vertx.core.Future;

public class MyVerticle extends AbstractVerticle {

    @Override
    public void start(Future<Void> startFuture) throws Exception {
        vertx.createHttpServer()
                .requestHandler(req -> {
                    req.response().end("hello from " + Thread.currentThread().getName());
                })
                .listen(8080);
    }
}
