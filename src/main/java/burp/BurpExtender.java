package burp;

import burp.IBurpExtender;
import burp.IBurpExtenderCallbacks;

import java.io.PrintWriter;

/*1.所有扩展必须实现IBurpExtender接口。
  2.实现类必须命名为BurpExtender，位于burp包中，必须声明为public，
*/
public class BurpExtender implements IBurpExtender {
    //实现IBurpExtender就必须实现里面的registerExtenderCallbacks
    @Override
    public void registerExtenderCallbacks(IBurpExtenderCallbacks callbacks) {
        //设置扩展在burp中的名称
        callbacks.setExtensionName("Hello World");

        //获取输出和错误流
        PrintWriter stdout=new PrintWriter(callbacks.getStdout(),true);
        PrintWriter stderr=new PrintWriter(callbacks.getStderr(),true);

        //向输出和错误流写入信息
        stdout.println("Hello output");
        stderr.println("Hello errors");

        //发布警报到 Burp 的警报标签页
        callbacks.issueAlert("Hello alerts");

        //抛出运行时异常
        throw new RuntimeException("Hello exception");
    }
}