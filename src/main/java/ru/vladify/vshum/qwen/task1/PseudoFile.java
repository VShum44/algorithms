package ru.vladify.vshum.qwen.task1;

public class PseudoFile {
    private final String name;
    private boolean processed;
    private boolean processing;

    public PseudoFile(String name) {
        this.name = name;
        this.processed = false;
        this.processing = false;
    }

    public String getName() {
        return name;
    }

    public boolean isProcessed() {
        return processed;
    }

    public void setProcessed(boolean processed) {
        this.processed = processed;
    }

    @Override
    public String toString() {
        return name;
    }

    public boolean isProcessing() {
        return processing;
    }

    public void setProcessing(boolean processing) {
        this.processing = processing;
    }
}
