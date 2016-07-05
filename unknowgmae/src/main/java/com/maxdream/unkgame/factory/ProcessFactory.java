package com.maxdream.unkgame.factory;

import com.android.fragmentbase.control.BaseFragmentControl;
import com.android.fragmentbase.factory.BaseFragmentFactory;
import com.android.fragmentbase.factory.BaseProcessFactory;
import com.android.fragmentbase.process.PageProcess;
import com.android.fragmentbase.process.ShapeProcess;
import com.maxdream.unkgame.control.FragmentControl;
import com.maxdream.unkgame.process.MainProcess;
import com.maxdream.unkgame.process.MapProcess;
import com.maxdream.unkgame.process.StoneProcess;

public class ProcessFactory extends BaseProcessFactory {

    public enum ProcessTypeEnum {main}

    public enum ShapeProcessEnum {stone, map}

    private static ProcessFactory instance = new ProcessFactory() {

    };

    private ProcessFactory() {

    }

    public static ProcessFactory getInstance() {
        return instance;
    }

    @Override
    protected PageProcess initProcess(String inputType, BaseFragmentFactory fragmentFactory, BaseFragmentControl fragmentControl) {
        PageProcess control = null;
        if (ProcessTypeEnum.main.toString().equals(inputType)) {
            control = new MainProcess(fragmentFactory, fragmentControl);
        }
        return control;
    }

    @Override
    protected ShapeProcess initShapeProcess(String inputType, PageProcess control, BaseFragmentFactory fragmentFactory, BaseFragmentControl fragmentControl) {
        ShapeProcess shapeControl = null;
        if (ShapeProcessEnum.stone.toString().equals(inputType)) {
            shapeControl = new StoneProcess(control, fragmentFactory, fragmentControl);
        } else if (ShapeProcessEnum.map.toString().equals(inputType)) {
            shapeControl = new MapProcess(control, fragmentFactory, fragmentControl);
        }
        return shapeControl;
    }

    @Override
    protected BaseFragmentControl getFragmentDefaultControl() {
        return FragmentControl.getInstance();
    }

    @Override
    protected BaseFragmentFactory getFragmentDefaultFactory() {
        return FragmentFactory.getInstance();
    }
}
