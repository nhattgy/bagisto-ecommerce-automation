package actions.factoryBrowser;

public class BrowserNotSupportedException extends IllegalStateException{
    public BrowserNotSupportedException(String browserName){
        super(String.format("Browser not support: %s")+ browserName);
    }
}
