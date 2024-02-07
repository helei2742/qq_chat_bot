package lhe.shinano.qq_chat.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Result {

    private boolean success;

    private String msg;

    private Object body;

    public Result(boolean success) {
        this.success = success;
    }
    public static Result success() {
        return new Result(true);
    }
    public static Result success(String msg) {
        Result result = new Result(true);
        result.setMsg(msg);
        return result;
    }
    public static Result success(Object body) {
        Result result = new Result(true);
        result.setBody(body);
        return result;
    }
    public static Result fail(String msg) {
        Result result = new Result(false);
        result.setMsg(msg);
        return result;
    }
    public static Result fail(Object body) {
        Result result = new Result(false);
        result.setBody(body);
        return result;
    }
}
