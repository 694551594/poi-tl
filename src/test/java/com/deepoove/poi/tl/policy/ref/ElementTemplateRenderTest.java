package com.deepoove.poi.tl.policy.ref;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.deepoove.poi.XWPFTemplate;
import com.deepoove.poi.data.PictureRenderData;

@DisplayName("Template Render test case")
public class ElementTemplateRenderTest {

    @SuppressWarnings("serial")
    @Test
    public void testPictureRender() throws Exception {
        Map<String, Object> data = new HashMap<String, Object>() {
            {
                put("title", "poi-tl");
                put("pic", new PictureRenderData(100, 120, ".png", new FileInputStream("src/test/resources/sayi.png")));
            }
        };
        Map<String, Object> data1 = new HashMap<String, Object>() {
            {
                put("title", "poi-tl2");
                put("pic", new PictureRenderData(100, 120, ".png", new FileInputStream("src/test/resources/logo.png")));
            }
        };

        List<Map<String, Object>> mores = new ArrayList<Map<String, Object>>();
        mores.add(data);
        mores.add(data1);
        Map<String, Object> datas = new HashMap<String, Object>() {
            {
                put("mores", mores);

            }
        };

        XWPFTemplate.compile("src/test/resources/template/render_picture_template.docx").render(datas)
                .writeToFile("out_render_picture_template.docx");
    }

    @Test
    public void testReplacePictureByOptionalText() throws Exception {

        @SuppressWarnings("serial")
        XWPFTemplate template = XWPFTemplate.compile("src/test/resources/template/render_picture_template1.docx")
                .render(new HashMap<String, Object>() {
                    {
                        put("img", new PictureRenderData(100, 120, ".png",
                                new FileInputStream("src/test/resources/sayi.png")));
                    }
                });

        template.writeToFile("out_render_picture_template1.docx");
    }

    @SuppressWarnings("serial")
    @Test
    public void testChartRender() throws Exception {
        Map<String, Object> data = new HashMap<String, Object>() {
            {
                put("title", "poi-tl");
                put("chart", null);
            }
        };

        Map<String, Object> data1 = new HashMap<String, Object>() {
            {
                put("title", "poi-tl2");
                put("chart", null);
            }
        };

        List<Map<String, Object>> mores = new ArrayList<Map<String, Object>>();
        mores.add(data);
        mores.add(data1);
        Map<String, Object> datas = new HashMap<String, Object>() {
            {
                put("mores", mores);

            }
        };

        XWPFTemplate.compile("src/test/resources/template/render_chart_template.docx").render(datas)
                .writeToFile("out_render_chart_template.docx");
    }

}
