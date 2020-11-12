
package co.daniel16.pokedex.modelAPI;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class GenerationViii {

    @SerializedName("icons")
    @Expose
    private Icons_ icons;

    /**
     * No args constructor for use in serialization
     * 
     */
    public GenerationViii() {
    }

    /**
     * 
     * @param icons
     */
    public GenerationViii(Icons_ icons) {
        super();
        this.icons = icons;
    }

    public Icons_ getIcons() {
        return icons;
    }

    public void setIcons(Icons_ icons) {
        this.icons = icons;
    }

}
