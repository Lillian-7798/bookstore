package com.reins.bookstore.utils.solrj;

import com.reins.bookstore.entity.Book;
import com.reins.bookstore.responsitory.BookResponsitory;
import org.apache.solr.client.solrj.SolrClient;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.impl.HttpSolrClient;
import org.apache.solr.client.solrj.response.UpdateResponse;
import org.apache.solr.common.SolrInputDocument;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.List;

@Component
public class BookBinding {
    @Autowired
    BookResponsitory bookResponsitory;

    public void main(String[] args) throws IOException, SolrServerException {
        final SolrClient client = getSolrClient();
//        final SolrInputDocument doc = new SolrInputDocument();
//        doc.addField("bookId",1);
//        doc.addField("bookName", "Amazon Kindle Paperwhite");
//        doc.addField("author", "t");
//        doc.addField("bookDescription", "xhhjhjkj");
//        final UpdateResponse updateResponse = client.add("book", doc);
//        // Indexed documents must be committed
//        client.commit("book");

        List<Book> books = bookResponsitory.getBooks();
        for(Book b:books){
            System.out.println("input book:"+b.getBookId());
            final UpdateResponse response =client.addBean("try",b);
            client.commit("try");
        }
    }
    public static SolrClient getSolrClient() {
        final String solrUrl = "http://localhost:8983/solr";
        return new HttpSolrClient.Builder(solrUrl)
                .withConnectionTimeout(10000)
                .withSocketTimeout(60000)
                .build();
    }
}
