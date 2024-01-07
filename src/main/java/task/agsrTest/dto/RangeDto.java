package task.agsrTest.dto;

public class RangeDto {
    private Integer from;
    private Integer to;

    public RangeDto(Integer from, Integer to) {
        this.from = from;
        this.to = to;
    }

    public RangeDto() {
    }

    public Integer getFrom() {
        return from;
    }

    public void setFrom(Integer from) {
        this.from = from;
    }

    public Integer getTo() {
        return to;
    }

    public void setTo(Integer to) {
        this.to = to;
    }

    @Override
    public String toString() {
        return "RangeDto{" +
                "from=" + from +
                ", to=" + to +
                '}';
    }

}