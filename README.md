# GiphyApi
Retrofit 2.3
### Приложение взаимодействует с api сайта https://giphy.com
#### Производится поиск гифок по запросу, изначально ключевые слова запроса "funny cats"

![Image alt](https://github.com/TishkevichLeonid/GiphyApi/raw/master/screenshots/1.jpg)

#### Отоборожение гифок осуществяется с помощью библиотеки Glide
```java
Glide.with(mContext)
                .load(mGiphyDataList.get(i).getImages().getOriginal().getUrl())
                .asGif()
                .placeholder(R.drawable.a1)
                .error(R.drawable.a2)
                .diskCacheStrategy(DiskCacheStrategy.SOURCE)
                .into(imageView);

```
#### После ввода запроса, по нажатию кнопки начнет отображаться результат запроса 

![Image alt](https://github.com/TishkevichLeonid/GiphyApi/raw/master/screenshots/2.jpg)

#### При повороте экрана сохраняется запрос, повторного скачивания данных не происходит

![Image alt](https://github.com/TishkevichLeonid/GiphyApi/raw/master/screenshots/3.jpg)

