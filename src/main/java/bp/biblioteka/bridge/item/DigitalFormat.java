package bp.biblioteka.bridge.item;

public class DigitalFormat implements ItemFormat {
    @Override
    public String format() {
        return "Format elektroniczny";
    }

    @Override
    public boolean isDownloadable() {
        return true;
    }
}
