package loc.com.myapplication.Model;

/**
 * Created by loc on 17/09/2015.
 */
public class ItemMenu {
        private int image;
    private String title;

    public ItemMenu(int image, String title) {
        this.image = image;
        this.title = title;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public ItemMenu() {

    }
}
