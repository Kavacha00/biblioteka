package bp.biblioteka.bridge;

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
