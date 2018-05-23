# s3Access
application.propertiesに
cloud.aws.credentials.accessKey=${S3_ACCESS_KEY}
cloud.aws.credentials.secretKey=${S3_SECRET_KEY}
cloud.aws.region.static=${S3_REGION_NAME}
cloud.aws.region.auto=false
を設定し
ResourcePatternResolver,ResourceLoader
をインジェクションするだけ。
s3://が対象だとよしなにしてくれる。

詳細は下記
https://cloud.spring.io/spring-cloud-aws/spring-cloud-aws.html

deleteはないので、deleteしたい場合は
S3Clientが必要となる。
今回は削除が必要ないのでサンプルには書いていない。

もしも必要ならば
巷にある情報はv1なので注意してv2を使用頂きたいです。

もし実装する場合、認証のキーなどは
https://docs.aws.amazon.com/ja_jp/sdk-for-java/v2/developer-guide/setup-credentials.html
に書いてあるように環境変数にぶち込んでください。
環境変数名：
AWS_ACCESS_KEY_ID
AWS_SECRET_ACCESS_KEY
AWS_REGION

v2の詳細は下記。サンプルなども詳しく載ってます。
https://docs.aws.amazon.com/ja_jp/sdk-for-java/v2/developer-guide/examples-s3-buckets.html#delete-objects-in-a-bucket