# s3Access
application.propertiesに
cloud.aws.credentials.accessKey=${AWS_ACCESS_KEY_ID}<br>
cloud.aws.credentials.secretKey=${AWS_SECRET_ACCESS_KEY}<br>
cloud.aws.region.static=${AWS_REGION}<br>
cloud.aws.region.auto=false<br>
を設定し<br>
ResourcePatternResolver,ResourceLoader<br>
をインジェクションするだけ。<br>
s3://が対象だとよしなにしてくれる。<br>

sampleは<br>
/src/main/java/com/example/s3Access/Aws/S3/S3Controller.java<br>
/src/main/java/com/example/s3Access/Aws/S3/S3Service.java<br>


詳細は下記<br>
https://cloud.spring.io/spring-cloud-aws/spring-cloud-aws.html<br>

deleteはないので、deleteしたい場合は<br>
S3Clientが必要となる。<br>
今回は削除が必要ないのでサンプルには書いていない。<br>
<br>
もしも必要ならば<br>
巷にある情報はv1なので注意してv2を使用頂きたいです。<br>
<br>
もし実装する場合、認証のキーなどは<br>
https://docs.aws.amazon.com/ja_jp/sdk-for-java/v2/developer-guide/setup-credentials.html<br>
に書いてあるように環境変数にぶち込んでください。<br>
環境変数名：<br>
AWS_ACCESS_KEY_ID<br>
AWS_SECRET_ACCESS_KEY<br>
AWS_REGION<br>
<br>
v2の詳細は下記。サンプルなども詳しく載ってます。<br>
https://docs.aws.amazon.com/ja_jp/sdk-for-java/v2/developer-guide/examples-s3-buckets.html#delete-objects-in-a-bucket<br>