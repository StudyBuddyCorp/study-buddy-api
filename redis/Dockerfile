FROM redis:7.2.4
COPY redis.conf /redis/redis.conf
RUN apt-get update && apt-get -y install iredis && apt-get clean
CMD [ "redis-server", "/redis/redis.conf" ]
