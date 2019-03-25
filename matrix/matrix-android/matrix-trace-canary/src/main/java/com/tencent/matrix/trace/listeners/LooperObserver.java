package com.tencent.matrix.trace.listeners;

import android.support.annotation.CallSuper;

import com.tencent.matrix.trace.core.UIThreadMonitor;

public abstract class LooperObserver implements UIThreadMonitor.IFrameObserver {

    private boolean isDispatchBegin = false;

    @CallSuper
    public void dispatchBegin(long beginMs, long cpuBeginMs, long token) {
        isDispatchBegin = true;
    }

    @Override
    public void doFrame(String focusedActivityName, long start, long end, long frameCostMs, long inputCostNs, long animationCostNs, long traversalCostNs) {

    }

    @CallSuper
    public void dispatchEnd(long beginMs, long cpuBeginMs, long endMs, long cpuEndMs, long token, boolean isBelongFrame) {
        isDispatchBegin = false;
    }

    public boolean isDispatchBegin() {
        return isDispatchBegin;
    }
}
