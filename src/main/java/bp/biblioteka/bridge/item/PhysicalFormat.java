package bp.biblioteka.bridge.item;

public class PhysicalFormat implements ItemFormat {
    @Override
    public String format() {
        return "Format fizyczny";
    }

    @Override
    public boolean isDownloadable() {
        return false;
    }
}
