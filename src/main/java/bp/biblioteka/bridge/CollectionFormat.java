package bp.biblioteka.bridge;

public class CollectionFormat implements ItemFormat {
    @Override
    public String format() {
        return "Różne formaty";
    }

    @Override
    public boolean isDownloadable() {
        return false;
    }
}
