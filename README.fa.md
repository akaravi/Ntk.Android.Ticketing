# Ntk.Android.Ticketing

اپ اندروید white-label پشتیبانی و محتوا — تیکت، FAQ، اخبار، مقالات و نظرسنجی روی پلتفرم NTK CMS.

## معرفی

`Ntk.Android.Ticketing` جریان‌های پشتیبانی مشتری (تیکت، FAQ، بازخورد) را در کنار ماژول‌های اخبار و مجلهٔ CMS ارائه می‌دهد. چند تم صفحهٔ اصلی (`MainActivity_1` تا `MainActivity_4`) برای استقرار white-label در دسترس است.

## مشخصات اپ

| فیلد | مقدار |
|------|-------|
| Application ID | `ntk.android.ticketing.APPNTK` |
| پکیج | `ntk.android.ticketing` |
| نسخهٔ کتابخانهٔ پایه | `1.6.43` (JitPack) |
| compileSdk / targetSdk | 33 |
| minSdk | 17 |

## قابلیت‌های اصلی

### پشتیبانی

- لیست، ایجاد، پاسخ و جستجوی تیکت (از BaseActivity)
- FAQ و راهنما
- بازخورد و دعوت از دوستان
- نظرسنجی

### محتوای CMS

- لیست، جزئیات و جستجوی اخبار
- لیست، جزئیات، جستجو و نمایش دسته‌بندی مقاله / مجله

### پلتفرم

- چیدمان‌های متنوع صفحهٔ اصلی (`MainActivity_1`–`_4`)
- دربارهٔ ما (تم تمام‌صفحه)
- دریافت SMS برای احراز هویت
- مانیتورینگ Sentry
- مجوز نصب APK برای به‌روزرسانی درون‌برنامه‌ای

## فناوری‌ها

- [Ntk.Android.BaseActivity](https://github.com/akaravi/Ntk.Android.BaseActivity) از JitPack `1.6.43`
- Retrofit 2.5 + RxJava 2
- ButterKnife، EventBus، Lottie، Flexbox
- کتابخانهٔ چندزبانه (`com.akexorcist:localization`)
- منوی Flowing drawer

## بیلد محلی

```bash
./gradlew :app:assembleDebug
```

برای توسعه با مخازن هم‌سطح، includeهای `baseActivity` / `baseApi` را در `settings.gradle` فعال کنید.

## وابستگی JitPack

```gradle
api "com.github.akaravi:Ntk.Android.BaseActivity:1.6.43"
```

## پروژه‌های مرتبط

| مخزن | نقش |
|------|-----|
| [Ntk.Android.Base](https://github.com/akaravi/Ntk.Android.Base) | کلاینت API |
| [Ntk.Android.BaseActivity](https://github.com/akaravi/Ntk.Android.BaseActivity) | کتابخانهٔ UI مشترک |
| [Ntk.Android.Biography](https://github.com/akaravi/Ntk.Android.Biography) | اپ زندگینامه |
| [Ntk.Android.Estate](https://github.com/akaravi/Ntk.Android.Estate) | اپ املاک |

## مجوز

اختصاصی — NTK.
