package com.maxdream.unkgame.control;


import com.android.fragmentbase.control.BaseProcessControl;
import com.android.fragmentbase.factory.BaseProcessFactory;
import com.android.fragmentbase.process.PageProcess;
import com.android.fragmentbase.process.ShapeProcess;
import com.maxdream.unkgame.factory.ProcessFactory;

public class ProcessControl extends BaseProcessControl {

    private boolean mapType, stoneType;

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
}
