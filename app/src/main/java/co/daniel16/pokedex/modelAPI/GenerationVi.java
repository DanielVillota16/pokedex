
package co.daniel16.pokedex.modelAPI;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class GenerationVi {

    @SerializedName("omegaruby-alphasapphire")
    @Expose
    private OmegarubyAlphasapphire omegarubyAlphasapphire;
    @SerializedName("x-y")
    @Expose
    private XY xY;

    /**
     * No args constructor for use in serialization
     * 
     */
    public GenerationVi() {
    }

    /**
     * 
     * @param xY
     * @param omegarubyAlphasapphire
     */
    public GenerationVi(OmegarubyAlphasapphire omegarubyAlphasapphire, XY xY) {
        super();
        this.omegarubyAlphasapphire = omegarubyAlphasapphire;
        this.xY = xY;
    }

    public OmegarubyAlphasapphire getOmegarubyAlphasapphire() {
        return omegarubyAlphasapphire;
    }

    public void setOmegarubyAlphasapphire(OmegarubyAlphasapphire omegarubyAlphasapphire) {
        this.omegarubyAlphasapphire = omegarubyAlphasapphire;
    }

    public XY getXY() {
        return xY;
    }

    public void setXY(XY xY) {
        this.xY = xY;
    }

}
