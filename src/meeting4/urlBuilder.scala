def urlBuilder (ssl: Boolean, domainName: String) : (String, String) => String =
	val schema = if ssl then "https://" else "http://"
	(endPoint: String, query: String) => s"$schema$domainName/$endPoint?$query"

val endPwQ = urlBuilder(true, "www.uni-tuebingen.de")

val result = endPwQ("q", "search");