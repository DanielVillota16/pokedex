
package co.daniel16.pokedex.modelAPI;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class VersionGroupDetail {

    @SerializedName("level_learned_at")
    @Expose
    private Integer levelLearnedAt;
    @SerializedName("version_group")
    @Expose
    private VersionGroup versionGroup;
    @SerializedName("move_learn_method")
    @Expose
    private MoveLearnMethod moveLearnMethod;

    /**
     * No args constructor for use in serialization
     * 
     */
    public VersionGroupDetail() {
    }

    /**
     * 
     * @param versionGroup
     * @param levelLearnedAt
     * @param moveLearnMethod
     */
    public VersionGroupDetail(Integer levelLearnedAt, VersionGroup versionGroup, MoveLearnMethod moveLearnMethod) {
        super();
        this.levelLearnedAt = levelLearnedAt;
        this.versionGroup = versionGroup;
        this.moveLearnMethod = moveLearnMethod;
    }

    public Integer getLevelLearnedAt() {
        return levelLearnedAt;
    }

    public void setLevelLearnedAt(Integer levelLearnedAt) {
        this.levelLearnedAt = levelLearnedAt;
    }

    public VersionGroup getVersionGroup() {
        return versionGroup;
    }

    public void setVersionGroup(VersionGroup versionGroup) {
        this.versionGroup = versionGroup;
    }

    public MoveLearnMethod getMoveLearnMethod() {
        return moveLearnMethod;
    }

    public void setMoveLearnMethod(MoveLearnMethod moveLearnMethod) {
        this.moveLearnMethod = moveLearnMethod;
    }

}
