package org.drools.runtime.rule;

public interface AgendaGroup {
    /**
     * @return
     *      The AgendaGroup name
     */
    public String getName();

    public void clear();

    public void setFocus();
}