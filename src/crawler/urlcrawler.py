import urllib2
import json
import codecs
import time
import httplib

def get_results(since):
	url = 'http://search.twitter.com/search.json?q=http&rpp=100&lang=en'
	
	response = urllib2.urlopen(url, timeout=10)
#	headers = response.info()	
#	print headers

	rawdata = response.read()
		
	data = json.loads(rawdata)
	return data['results']

def strip(string):

	if string != None:
		string = string.replace('\t', ' ')
		string = string.replace('\n', ' ')
		string = string.replace('\r', ' ')
		string = string.replace('\f', ' ')
	else:
		string = ''
	
	return string


# **********************
# MAIN LOOP:

file = codecs.open('dataset', 'a', encoding='utf-8')

since = ''

while(1):
	print 'Fetching since ' + since 
	is_first = True
	try:
		results = get_results(since)
		for result in results:
			if is_first:
				since = str(int(result['id']) + 1)
				is_first = False
			
			line = "%s\t%s\t%s\t%s\t%s\t%s\t%s\t%s\t%s\n" % (result['id'], strip(result['text']), strip(result['created_at']), strip(result['source']), strip(str(result['geo'])), strip(result['from_user']), result['from_user_id'], result['to_user_id'], strip(result['profile_image_url']))
			
			file.write(line)
			file.flush()
	except urllib2.HTTPError as ex:
		print 'HTTPERROR! Code: ' + str(ex.code)
		if ex.code == 420:
			retry_after = int(ex.info()['Retry-After'])
			print 'SLEEPING AND WILL RETRY AFTER %d SECS' % retry_after
			time.sleep(retry_after)
			print 'NOW RESUMING'
	except urllib2.URLError as ex:
		print 'URLERROR!'
	except httplib.IncompleteRead as ex:
		print 'INCOMPLETEREAD!'
		
		
file.close()