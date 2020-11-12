
package co.daniel16.pokedex.modelAPI;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class GenerationI {

    @SerializedName("red-blue")
    @Expose
    private RedBlue redBlue;
    @SerializedName("yellow")
    @Expose
    private Yellow yellow;

    /**
     * No args constructor for use in serialization
     * 
     */
    public GenerationI() {
    }

    /**
     * 
     * @param yellow
     * @param redBlue
     */
    public GenerationI(RedBlue redBlue, Yellow yellow) {
        super();
        this.redBlue = redBlue;
        this.yellow = yellow;
    }

    public RedBlue getRedBlue() {
        return redBlue;
    }

    public void setRedBlue(RedBlue redBlue) {
        this.redBlue = redBlue;
    }

    public Yellow getYellow() {
        return yellow;
    }

    public void setYellow(Yellow yellow) {
        this.yellow = yellow;
    }

}
