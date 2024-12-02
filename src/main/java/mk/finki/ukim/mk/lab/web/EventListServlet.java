//package mk.finki.ukim.mk.lab.web;
//
//import jakarta.servlet.ServletException;
//import jakarta.servlet.annotation.WebServlet;
//import jakarta.servlet.http.HttpServlet;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//import mk.finki.ukim.mk.lab.service.EventService;
//import org.thymeleaf.context.WebContext;
//import org.thymeleaf.spring6.SpringTemplateEngine;
//import org.thymeleaf.web.IWebExchange;
//import org.thymeleaf.web.servlet.JakartaServletWebApplication;
//
//import java.io.IOException;
//
//
//@WebServlet(name = "EventListServlet", urlPatterns = "/t")
//public class EventListServlet extends HttpServlet {
//
//    private final EventService eventService;
//    private final SpringTemplateEngine springTemplateEngine;
//
//    public EventListServlet(EventService eventService, SpringTemplateEngine springTemplateEngine) {
//        this.eventService = eventService;
//        this.springTemplateEngine = springTemplateEngine;
//    }
//
//    @Override
//    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        IWebExchange webExchange = JakartaServletWebApplication
//                .buildApplication(getServletContext())
//                .buildExchange(req, resp);
//
//        WebContext context = new WebContext(webExchange);
//        String filterRating = req.getParameter("filterRating");
//        String filterName = req.getParameter("filterName");
//
//        if(filterRating == null || filterName == null){
//            context.setVariable("events", eventService.listAll());
//      } else {
//            if(filterRating.isBlank()){
//                filterRating = "0";
//            }
//            context.setVariable("events", eventService.searchEvents(filterName, Integer.parseInt(filterRating)));
//        }
//
//        springTemplateEngine.process("listEvents.html", context, resp.getWriter());
//    }
//
//
//}
