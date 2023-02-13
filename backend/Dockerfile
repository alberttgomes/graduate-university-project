FROM mysql:latest

RUN echo "Init build sql database image..."

RUN chown -R mysql:root /var/lib/mysql/

ENV MYSQL_DATABASE=database-placamae
ENV MYSQL_USER=placamae-database-user
ENV MYSQL_PASSWORD=1234