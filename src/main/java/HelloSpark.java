import spark.ModelAndView;
import spark.Redirect;
import spark.template.pebble.PebbleTemplateEngine;

import java.util.HashMap;
import java.util.Map;

import static spark.Spark.*;

public class HelloSpark {
    public static void main(String[] args){
        //get("/hello", (req, res) -> "Hello Spark!");
            //System.out.println("Sparks....");
        port(9999);

        get("/call/:name", (request, response) -> {
            return "Call me " + request.params(":name");
        });

        redirect.get("/hello", "/call/lionsleepy", Redirect.Status.MOVED_PERMANENTLY);

        get("/pebble", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            model.put("msg", "New world of Pebble");

            return new ModelAndView(model, "pebble/new.pebble");
        }, new PebbleTemplateEngine());
    }
}
