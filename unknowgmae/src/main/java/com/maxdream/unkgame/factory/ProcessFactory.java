package com.maxdream.unkgame.factory;

import com.maxdream.unkgame.layoutstatus.PageProcess;
import com.maxdream.android.process.ShapeProcess;
import com.maxdream.unkgame.process.MainProcess;
import com.maxdream.unkgame.process.MapProcess;
import com.maxdream.unkgame.process.StoneProcess;
import com.maxdream.unkgame.util.Constants;

public class ProcessFactory {

    public PageProcess getProcess(String inputType) {
        PageProcess control = null;
        if (Constants.ControlTypeEnum.main.toString().equals(inputType)) {
            control = new MainProcess();
        }
        return control;
    }

    public PageProcess getShapeProcess(String inputType, PageProcess control) {
        ShapeProcess shapeControl = null;
        if (Constants.ControlTypeEnum.stone.toString().equals(inputType)) {
            shapeControl = new StoneProcess(control);
        }else if (Constants.ControlTypeEnum.map.toString().equals(inputType)) {
            shapeControl = new MapProcess(control);
        }
        return shapeControl;
    }
}
