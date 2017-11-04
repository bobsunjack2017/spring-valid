package com.demo4.aop;


import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;
import net.sf.json.util.PropertyFilter;
import org.springframework.web.servlet.view.json.MappingJacksonJsonView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class RenderJsonView extends MappingJacksonJsonView {

    protected void renderMergedOutputModel(Map<String, Object> model,
                                           HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        Map<?, ?> result = (Map<?, ?>) super.filterModel(model);
        Object obj = null;
        if (result.values().iterator().hasNext()) {
            obj = result.values().iterator().next();
        }
        JsonConfig config = new JsonConfig();
        config.setJsonPropertyFilter(new PropertyFilter() {
            public boolean apply(Object arg0, String arg1, Object arg2) {
                if (arg2 instanceof Set) {
                    return true;
                }
                return false;
            }
        });
        if (obj instanceof List) {
            response.getWriter().println(JSONArray.fromObject(obj, config));
        } else {
            response.getWriter().println(JSONObject.fromObject(obj, config));
        }
    }

}