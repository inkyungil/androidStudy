package com.example.wowapplication.service
import com.example.wowapplication.service.request.AsReportDeleteRequest
import com.example.wowapplication.service.request.LoginRequest
import com.example.wowapplication.service.request.StoreListRequest
import com.example.wowapplication.service.response.AsReportDetailResponse
import com.example.wowapplication.service.response.AsReportListResponse
import com.example.wowapplication.service.response.AsReportListSearchResponse
import com.example.wowapplication.service.response.AsReportResponse
import com.example.wowapplication.service.response.AsTypeResponse
import com.example.wowapplication.service.response.BrandResponse
import com.example.wowapplication.service.response.ChartCaseResponse
import com.example.wowapplication.service.response.LoginResponse
import com.example.wowapplication.service.response.StoreResponse
import com.example.wowapplication.service.response.WowBaseResponse
import okhttp3.MultipartBody
import okhttp3.RequestBody
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Multipart
import retrofit2.http.POST
import retrofit2.http.Part
import retrofit2.http.Query
import retrofit2.http.QueryMap

interface ApiService {
    //로그인
    @POST("login.php")
    fun loginUser(@Body request: LoginRequest): Call<LoginResponse>

    //브랜드 리스트
    @POST("getBrandList.php")
    fun getBrandList(): Call<ApiResponse<List<BrandResponse>>>

    //지점 리스트
    @POST("getStoreList.php")
    fun getStoreList(@Body request: StoreListRequest): Call<ApiResponse<List<StoreResponse>>>

    //AsType 리스트
    @POST("asCodeList.php")
    fun getAsTypeList(): Call<ApiResponse<List<AsTypeResponse>>>

    //AS 등록
    @Multipart
    @POST("asReport.php")
    fun writeAsReport(@Part("bcode") bcode: RequestBody,
                      @Part("scode") scode: RequestBody,
                      @Part("ascode") ascode: RequestBody,
                      @Part("asTime") asTime: RequestBody,
                      @Part("content") content: RequestBody,
                      @Part("id") id: RequestBody,
                      @Part images: List<MultipartBody.Part>) : Call<ApiResponse<AsReportResponse>>

    //AS 등록
    @Multipart
    @POST("asReportUpdate.php")
    fun editAsReport(@Part("bcode") bcode: RequestBody,
                      @Part("scode") scode: RequestBody,
                      @Part("ascode") ascode: RequestBody,
                      @Part("asTime") asTime: RequestBody,
                      @Part("content") content: RequestBody,
                      @Part("id") id: RequestBody,
                      @Part("idx") idx: RequestBody,
                      @Part("flag") flag: RequestBody,
                      @Part images: List<MultipartBody.Part>) : Call<ApiResponse<AsReportResponse>>

    //AS 내역 리스트
    @GET("asReportList.php")
    fun getAsReportList(@Query("page") page: Int): Call<AsReportListResponse>

    //AS 내역 리스트 검색
    @GET("asReportSearch.php")
    fun getAsReportListSearch(@QueryMap params: Map<String, String>): Call<AsReportListSearchResponse>

    //AS 내역 상세
    @GET("asReportDetail.php")
    fun getAsReportDetail(@Query("idx") idx: String): Call<AsReportDetailResponse>

    //AS 삭제
    @POST("asReportDel.php")
    fun getAsReportDelete(@Body request: AsReportDeleteRequest): Call<WowBaseResponse>

    //AS 내역 리스트 검색
    @GET("chartCase1.php")
    fun getAsReportChartCase1(@QueryMap params: Map<String, String>): Call<ChartCaseResponse>
}
