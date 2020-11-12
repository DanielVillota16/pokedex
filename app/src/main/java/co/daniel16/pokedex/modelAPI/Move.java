
package co.daniel16.pokedex.modelAPI;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Move {

    @SerializedName("move")
    @Expose
    private Move_ move;
    @SerializedName("version_group_details")
    @Expose
    private List<VersionGroupDetail> versionGroupDetails = new ArrayList<VersionGroupDetail>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public Move() {
    }

    /**
     * 
     * @param move
     * @param versionGroupDetails
     */
    public Move(Move_ move, List<VersionGroupDetail> versionGroupDetails) {
        super();
        this.move = move;
        this.versionGroupDetails = versionGroupDetails;
    }

    public Move_ getMove() {
        return move;
    }

    public void setMove(Move_ move) {
        this.move = move;
    }

    public List<VersionGroupDetail> getVersionGroupDetails() {
        return versionGroupDetails;
    }

    public void setVersionGroupDetails(List<VersionGroupDetail> versionGroupDetails) {
        this.versionGroupDetails = versionGroupDetails;
    }

}
