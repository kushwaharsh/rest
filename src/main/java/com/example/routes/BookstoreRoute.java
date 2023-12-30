package com.example.routes;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class BookstoreRoute extends RouteBuilder {

    @Override
    public void configure() throws Exception {
        rest("/books")
            .get()
                .to("direct:getBooks")
            .get("/{id}")
                .to("direct:getBook")
            .post()
                .to("direct:addBook")
            .put("/{id}")
                .to("direct:updateBook")
            .delete("/{id}")
                .to("direct:deleteBook");

        // Define corresponding direct endpoints for each operation
        from("direct:getBooks").to("bean:bookService?method=getBooks");
        from("direct:getBook").to("bean:bookService?method=getBook(${header.id})");
        from("direct:addBook").to("bean:bookService?method=addBook");
        from("direct:updateBook").to("bean:bookService?method=updateBook(${header.id})");
        from("direct:deleteBook").to("bean:bookService?method=deleteBook(${header.id})");
    }
}
