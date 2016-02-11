package xyz.yoloz.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import xyz.yoloz.security.ApiController;

/**
 * Created by tienhd on 11/2/16.
 */
@RestController
@RequestMapping (path = ApiController.METRIC_ENDPOINT)
public class MetricController {

    @RequestMapping (path = "/test" , method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<String> testMetric() {
        return new ResponseEntity<String>("Test", HttpStatus.OK);
    }
}
