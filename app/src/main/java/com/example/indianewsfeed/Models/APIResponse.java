package com.example.indianewsfeed.Models;

import java.io.Serializable;
import java.util.List;

public class APIResponse implements Serializable {
    List<Headlines> articles;

    public List<Headlines> getArticles() {
        return articles;
    }

}