# 🛒 Alışveriş Sitesi Backend – Test ve CI/CD Odaklı Proje

Bu proje, Spring Boot kullanılarak geliştirilmiş,
çok katmanlı mimariye sahip,
test odaklı ve CI/CD süreçleri otomatikleştirilmiş bir alışveriş sitesi backend uygulamasıdır.

Amaç; yalnızca çalışan bir sistem geliştirmek değil,
aynı zamanda birim, entegrasyon ve sistem/API testleri ile doğrulanmış,
Docker ve Jenkins destekli,
sürdürülebilir ve profesyonel bir backend mimarisi oluşturmaktır.

---

## 🎯 Proje Amacı

- Gerçekçi bir alışveriş sitesi backend mimarisi geliştirmek
- Yazılım test seviyelerini (Unit / Integration / System) uygulamak
- Jenkins ile otomatik CI/CD süreci oluşturmak
- Uygulamayı tamamen Docker container’ları üzerinde çalıştırmak
- Test sonuçlarını otomatik olarak raporlayan bir yapı kurmak

---

## 🏗️ Mimari Yapı

Proje, Katmanlı Mimari (N-Tier Architecture) yaklaşımı ile geliştirilmiştir.

### Katmanlar

| Katman | Açıklama |
|------|---------|
| API (Controller) | HTTP isteklerini karşılar |
| Business (Service) | İş kuralları ve doğrulamalar |
| DataAccess (Repository) | Veritabanı işlemleri |
| Entities | Domain modelleri |
| Tests | Unit, Integration ve System/API testleri |

---

## 🔄 Test Yaklaşımı

### 🧪 Unit Testleri
- Business katmanındaki iş kurallarını test eder
- Mockito ile mock yapılar kullanılmıştır

### 🔗 Integration Testleri
- Katmanlar arası etkileşimi test eder
- Gerçek Spring Context ile çalışır

### 🌐 System / API Testleri
- Uçtan uca senaryoları doğrular
- Çalışan sistem üzerinden API testleri yapılır

---

## 📊 Otomatik Test Sonuçları

- 🧪 Unit Testleri: 5 / 5 ✅
- 🔗 Integration Testleri: 3 / 3 ✅
- 🌐 System / API Testleri: 3 / 3 ✅
- ⏱️ Toplam test süresi: ~35 saniye
- ❌ Hata oranı: %0

---

## 🛠️ Kullanılan Teknolojiler

- Java 17+
- Spring Boot
- Spring Web
- Spring Data JPA
- Maven
- JUnit
- Mockito
- Docker
- Docker Compose
- Jenkins
- Swagger (OpenAPI)

---

## ⚙️ CI/CD Süreci

Her push işleminde aşağıdaki adımlar otomatik olarak çalışır:

1. Kodlar repodan çekilir
2. Proje build edilir
3. Unit testler çalıştırılır
4. Integration testler çalıştırılır
5. Docker container’ları ayağa kaldırılır
6. Çalışan sistem üzerinden API testleri gerçekleştirilir

---

## 🐳 Docker Kullanımı

- Ortam bağımlılıkları izole edilmiştir
- Lokal makinede Java / Maven kurulumu gerekmez
- CI/CD süreçleriyle birebir uyumludur

---

## ▶️ Uygulamayı Çalıştırma

### Gereksinimler

- Docker
- Docker Compose
- Git

---

### 1️⃣ Projeyi Klonlayın

```bash
git clone https://github.com/fatmagul-yilmaz/ecommerce-backend-ci-cd.git
cd ecommerce-backend-ci-cd
```

---

### 2️⃣ Container’ları Ayağa Kaldırın

```bash
docker-compose up --build
```

Uygulama build edilir ve gerekli servisler başlatılır.

---

### 3️⃣ Swagger ile API Testi

```text
http://localhost:8084/swagger-ui/index.html
```

---

### 4️⃣ Testleri Manuel Çalıştırma

```bash
docker-compose run app mvn test
```

---

### 5️⃣ Container’ları Durdurma

```bash
docker-compose down
```


### 👩‍💻 Geliştirici

**Fatmagül Yılmaz**
