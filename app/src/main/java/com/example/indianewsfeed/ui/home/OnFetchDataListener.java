package com.example.indianewsfeed.ui.home;

import com.example.indianewsfeed.Models.Headlines;

import java.util.List;

public interface OnFetchDataListener<APIResponse>
{
    void onFetchData(List<Headlines> list, String message);
    void onError(String message);

}
