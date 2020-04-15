import io.netty.bootstrap.Bootstrap;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;

import java.net.InetSocketAddress;

public class Test {
    public static void main(String[] args) {
//        for (int i = 3; i >= 0; i--) {
//            try {
//                int[] arr = new int[Integer.MAX_VALUE-i];
//                System.out.format("Successfully initialized an array with%,d elements.\n", Integer.MAX_VALUE-i);
//            } catch (Throwable t) {
//                t.printStackTrace();
//            }
//        }

        ServerBootstrap serverBootstrap = new ServerBootstrap();
        serverBootstrap.group(new NioEventLoopGroup(), new NioEventLoopGroup())
                .channel(NioServerSocketChannel.class)
                .childHandler(new SimpleChannelInboundHandler<ByteBuf>() {
                    ChannelFuture connectFuture;
                    @Override
                    public void channelActive(ChannelHandlerContext ctx) throws Exception {
                        // 使用bootstrap实例连接到第三方主机
                        Bootstrap bootstrap = new Bootstrap();
                        bootstrap.channel(NioSocketChannel.class)
                                .handler(new SimpleChannelInboundHandler<ByteBuf>() {
                                    @Override
                                    protected void channelRead0(ChannelHandlerContext ctx, ByteBuf msg) throws Exception {
                                        System.out.println("receied data");
                                    }
                                });

                        bootstrap.group(ctx.channel().eventLoop());
                        connectFuture = bootstrap.connect(new InetSocketAddress("hostname", 80));
                    }

                    @Override
                    protected void channelRead0(ChannelHandlerContext ctx, ByteBuf msg) throws Exception {
                        if(connectFuture.isDone()){
                            // 连接完成时, 执行一些数据操作
                            // do sth.
                        }
                    }
                });

        ChannelFuture future = serverBootstrap.bind(new InetSocketAddress(8080));
        future.addListener(new ChannelFutureListener() {
            @Override
            public void operationComplete(ChannelFuture future) throws Exception {

                if(future.isSuccess()){
                    System.out.println("xx");
                }else{
                    System.err.println("xxxx");
                    future.cause().printStackTrace();
                }
            }

        });



    }
}
