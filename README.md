# Kitap API

Bu proje, kitap ve kategori takibini yapmak için Spring Boot kullanılarak geliştirilmiş basit bir REST API uygulamasıdır.

Projede kitap ekleme, listeleme, detay görüntüleme, güncelleme, silme ve kitap adına göre arama işlemleri yapılmaktadır. Ayrıca MySQL veritabanı kullanılmıştır.
## Proje Yapısı

Projede katmanlı bir yapı kullanılmıştır.

### Controller

Dışarıdan gelen HTTP isteklerini karşılar. Postman'den gelen GET, POST, PUT ve DELETE istekleri Controller tarafından alınır.

### Service

Uygulamanın işlemlerinin yürütüldüğü katmandır. Controller'dan gelen isteği işler ve Repository ile iletişim kurar.

### Repository

Veritabanı işlemlerini gerçekleştirir. Spring Data JPA kullanılarak kitap ve kategori verilerine erişim sağlanır.

### Entity

Veritabanındaki tabloları temsil eder. Projede `Product` ve `Category` entity'leri bulunmaktadır.

### DTO

API'ye gelen ve API'den dönen verilerin entity'den ayrı şekilde taşınmasını sağlar. `ProductRequestDto` isteklerde, `BookResponseDto` ise cevaplarda kullanılmıştır.

### Genel Akış

Postman → Controller → Service → Repository → MySQL
## API Endpointleri

### Kitap İşlemleri

| Method | Endpoint | Açıklama |
|---|---|---|
| GET | `/books` | Tüm kitapları listeler |
| GET | `/books/{id}` | ID'ye göre kitap getirir |
| GET | `/books/search?name=...` | Kitap adına göre arama yapar |
| POST | `/books` | Yeni kitap ekler |
| PUT | `/books/{id}` | Kitap bilgilerini günceller |
| DELETE | `/books/{id}` | Kitap siler |

### Kategori İşlemleri

| Method | Endpoint | Açıklama |
|---|---|---|
| GET | `/categories` | Tüm kategorileri listeler |
| POST | `/categories` | Yeni kategori ekler |
## Validation

Ürün yerine kitap için temel girdi doğrulaması uygulanmıştır.

- Kitap adı boş bırakılamaz.
- Fiyat negatif olamaz.
- Geçersiz bir istek gönderildiğinde HTTP 400 Bad Request döner.

Örnek geçersiz istek:

```json
{
    "name": "",
    "price": -50
}
## Hata Yönetimi

Geçersiz bir kitap ID'si ile işlem yapılması durumunda HTTP 404 Not Found döndürülmektedir.

Aşağıdaki işlemler geçersiz ID ile test edilmiştir:

- GET `/books/999` → 404
- PUT `/books/999` → 404
- DELETE `/books/999` → 404

## Postman Testleri

API işlemleri Postman üzerinden test edilmiştir.

Test edilen işlemler:

- Kitap listeleme
- Kitap detayını görüntüleme
- Kitap ekleme
- Kitap güncelleme
- Kitap silme
- Kitap adına göre arama
- Kategori listeleme
- Kategori ekleme
- Geçersiz veri gönderme → 400
- Bulunamayan kitap ID'si → 404

kısacaa==Bu projede Spring Boot kullanarak basit bir kitap ve kategori takip API'si geliştirdim.

Projede Java 17, Spring Boot, Spring Data JPA ve MySQL kullandım. API işlemlerini de Postman üzerinden test ettim.

Projede Controller, Service ve Repository şeklinde katmanlı bir yapı kullandım. Dışarıdan gelen istek önce Controller'a geliyor. Controller bu isteği Service'e gönderiyor. Service işlemi gerçekleştiriyor ve veritabanı işlemleri için Repository'yi kullanıyor. Repository de MySQL ile iletişim kuruyor.

Kitap tarafında listeleme, detay görüntüleme, ekleme, güncelleme, silme ve kitap adına göre arama işlemlerini yaptım. Ayrıca kategori ekleme ve kategori listeleme işlemlerini de gerçekleştirdim.

Daha sonra DTO yapısını ekledim. BookRequestDto ile API'ye gelen verileri, BookResponseDto ile API'den dönen verileri entity'den ayrı şekilde taşıdım.

Girdi doğrulaması da ekledim. Kitap adı boş bırakıldığında veya fiyat negatif gönderildiğinde sistem 400 Bad Request döndürüyor.

Ayrıca olmayan bir kitap ID'si ile GET, PUT veya DELETE işlemi yapıldığında 404 Not Found dönecek şekilde hata yönetimi ekledim.

Son olarak yaptığım işlemleri Postman üzerinden test ettim ve proje yapısını README dosyasında açıkladım.
