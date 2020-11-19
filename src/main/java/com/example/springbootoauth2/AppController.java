package com.example.springbootoauth2;

import org.json.JSONObject;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AppController {

  @RequestMapping(value = "/api/public", method = RequestMethod.GET, produces = "application/json")
  @ResponseBody
  public String publicEndpoint() {
    return new JSONObject()
      .put("message", "Hello from a public endpoint! You don\'t need to be authenticated to see this.")
      .toString();
  }

  @RequestMapping(value = "/api/private", method = RequestMethod.GET, produces = "application/json")
  @ResponseBody
  public String privateEndpoint() {
    return new JSONObject()
      .put("message", "Hello from a private endpoint! You need to be authenticated to see this.")
      .toString();
  }

  @RequestMapping(value = "/api/private-scoped", method = RequestMethod.GET, produces = "application/json")
  @ResponseBody
  public String privateScopedEndpoint() {
    return new JSONObject()
      .put("message", "Hello from a private endpoint! You need to be authenticated and have a scope of read:messages to see this.")
      .toString();
  }
}
