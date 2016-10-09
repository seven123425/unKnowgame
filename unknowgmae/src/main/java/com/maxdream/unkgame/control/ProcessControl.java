package com.maxdream.unkgame.control;


import com.android.fragmentbase.control.BaseProcessControl;
import com.android.fragmentbase.factory.BaseProcessFactory;
import com.android.fragmentbase.process.PageProcess;
import com.android.fragmentbase.process.ShapeProcess;
import com.maxdream.unkgame.factory.ProcessFactory;

public class ProcessControl extends BaseProcessControl {

    private boolean mapType, stoneType, backType, alterType, characterType, teamType;

    private BaseProcessFactory factory = ProcessFactory.getInstance();

    private static ProcessControl instance = new ProcessControl();

    private ProcessControl() {

    }

    public static ProcessControl getInstance() {
        return instance;
    }

    @Override
    protected PageProcess homeProcess() {
        return ProcessFactory.getInstance().getProcess(ProcessFactory.ProcessTypeEnum.main.toString());
    }

    public boolean isMapType() {
        return mapType;
    }

    public void setMapType(boolean mapType) {
        this.mapType = mapType;
        if (mapType) {
            initShapePageControl(factory, ProcessFactory.ShapeProcessEnum.map.toString());
            FragmentControl.getInstance().changeNextPage(this);
        } else {
            if (process instanceof ShapeProcess) {
                process = ((ShapeProcess) process).getLastControl();
                FragmentControl.getInstance().changeLastPage(this);
            }
        }
    }

    public boolean isStoneType() {
        return stoneType;
    }

    public void setStoneType(boolean stoneType) {
        this.stoneType = stoneType;
        if (stoneType) {
            initShapePageControl(factory, ProcessFactory.ShapeProcessEnum.stone.toString());
            FragmentControl.getInstance().changeNextPage(this);
        } else {
            if (process instanceof ShapeProcess) {
                process = ((ShapeProcess) process).getLastControl();
                FragmentControl.getInstance().changeLastPage(this);
            }
        }
    }

    public boolean isBackType() {
        return stoneType;
    }

    public void setBackType(boolean backType) {
        this.backType = backType;
        if (backType) {
            initShapePageControl(factory, ProcessFactory.ShapeProcessEnum.back.toString());
            FragmentControl.getInstance().changeNextPage(this);
        } else {
            if (process instanceof ShapeProcess) {
                process = ((ShapeProcess) process).getLastControl();
                FragmentControl.getInstance().changeLastPage(this);
            }
        }
    }

    public boolean isAlterType() {
        return alterType;
    }

    public void setAlterType(boolean alterType) {
        this.alterType = alterType;
        if (alterType) {
            initShapePageControl(factory, ProcessFactory.ShapeProcessEnum.alter.toString());
            FragmentControl.getInstance().changeNextPage(this);
        } else {
            if (process instanceof ShapeProcess) {
                process = ((ShapeProcess) process).getLastControl();
                FragmentControl.getInstance().changeLastPage(this);
            }
        }
    }

    public boolean isCharacterType() {
        return characterType;
    }

    public void setCharacterType(boolean characterType) {
        this.characterType = characterType;
        if (characterType) {
            initShapePageControl(factory, ProcessFactory.ShapeProcessEnum.character.toString());
            FragmentControl.getInstance().changeNextPage(this);
        } else {
            if (process instanceof ShapeProcess) {
                process = ((ShapeProcess) process).getLastControl();
                FragmentControl.getInstance().changeLastPage(this);
            }
        }
    }

    public boolean isTeamType() {
        return teamType;
    }

    public void setTeamType(boolean teamType) {
        this.teamType = teamType;
        if (teamType) {
            initShapePageControl(factory, ProcessFactory.ShapeProcessEnum.team.toString());
            FragmentControl.getInstance().changeNextPage(this);
        } else {
            if (process instanceof ShapeProcess) {
                process = ((ShapeProcess) process).getLastControl();
                FragmentControl.getInstance().changeLastPage(this);
            }
        }
    }
}
