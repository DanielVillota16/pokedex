
package co.daniel16.pokedex.modelAPI;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class GenerationVii {

    @SerializedName("icons")
    @Expose
    private Icons icons;
    @SerializedName("ultra-sun-ultra-moon")
    @Expose
    private UltraSunUltraMoon ultraSunUltraMoon;

    /**
     * No args constructor for use in serialization
     * 
     */
    public GenerationVii() {
    }

    /**
     * 
     * @param ultraSunUltraMoon
     * @param icons
     */
    public GenerationVii(Icons icons, UltraSunUltraMoon ultraSunUltraMoon) {
        super();
        this.icons = icons;
        this.ultraSunUltraMoon = ultraSunUltraMoon;
    }

    public Icons getIcons() {
        return icons;
    }

    public void setIcons(Icons icons) {
        this.icons = icons;
    }

    public UltraSunUltraMoon getUltraSunUltraMoon() {
        return ultraSunUltraMoon;
    }

    public void setUltraSunUltraMoon(UltraSunUltraMoon ultraSunUltraMoon) {
        this.ultraSunUltraMoon = ultraSunUltraMoon;
    }

}
