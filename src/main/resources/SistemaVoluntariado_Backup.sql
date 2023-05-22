toc.dat                                                                                             0000600 0004000 0002000 00000036655 14432544376 0014472 0                                                                                                    ustar 00postgres                        postgres                        0000000 0000000                                                                                                                                                                        PGDMP           ,                {            SistemaVoluntariado    15.2    15.2 5    K           0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                      false         L           0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                      false         M           0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                      false         N           1262    33096    SistemaVoluntariado    DATABASE     �   CREATE DATABASE "SistemaVoluntariado" WITH TEMPLATE = template0 ENCODING = 'UTF8' LOCALE_PROVIDER = libc LOCALE = 'Spanish_Mexico.1252';
 %   DROP DATABASE "SistemaVoluntariado";
                postgres    false         �            1259    33109    eme_habilidad    TABLE     �   CREATE TABLE public.eme_habilidad (
    id numeric(8,0) NOT NULL,
    id_emergencia numeric(6,0),
    id_habilidad numeric(4,0)
);
 !   DROP TABLE public.eme_habilidad;
       public         heap    postgres    false         �            1259    33112 
   emergencia    TABLE     �   CREATE TABLE public.emergencia (
    id numeric(6,0) NOT NULL,
    nombre character varying(100),
    descrip character varying(400),
    finicio date,
    ffin date,
    id_institucion numeric(4,0)
);
    DROP TABLE public.emergencia;
       public         heap    postgres    false         �            1259    33117    estado_tarea    TABLE     f   CREATE TABLE public.estado_tarea (
    id numeric(2,0) NOT NULL,
    descrip character varying(20)
);
     DROP TABLE public.estado_tarea;
       public         heap    postgres    false         �            1259    33120 	   habilidad    TABLE     d   CREATE TABLE public.habilidad (
    id numeric(4,0) NOT NULL,
    descrip character varying(100)
);
    DROP TABLE public.habilidad;
       public         heap    postgres    false         �            1259    33123    institucion    TABLE     �   CREATE TABLE public.institucion (
    id numeric(4,0) NOT NULL,
    nombre character varying(100),
    descrip character varying(400)
);
    DROP TABLE public.institucion;
       public         heap    postgres    false         �            1259    33128    ranking    TABLE     �   CREATE TABLE public.ranking (
    id numeric(8,0) NOT NULL,
    id_voluntario numeric(8,0),
    id_tarea numeric(8,0),
    puntaje numeric(3,2),
    flg_invitado numeric(1,0),
    flg_participa numeric(1,0)
);
    DROP TABLE public.ranking;
       public         heap    postgres    false         O           0    0    TABLE ranking    COMMENT     u   COMMENT ON TABLE public.ranking IS 'los flgInvitado, flgParticipa 1 si la respuesta es si, 2 si la respuesta es no';
          public          postgres    false    219         �            1259    33131    tarea    TABLE     *  CREATE TABLE public.tarea (
    id numeric(8,0) NOT NULL,
    nombre character varying(60),
    descrip character varying(300),
    cant_vol_requeridos numeric(4,0),
    cant_vol_inscritos numeric(4,0),
    id_emergencia numeric(6,0),
    finicio date,
    ffin date,
    id_estado numeric(2,0)
);
    DROP TABLE public.tarea;
       public         heap    postgres    false         �            1259    33134    tarea_habilidad    TABLE     }   CREATE TABLE public.tarea_habilidad (
    id numeric(8,0) NOT NULL,
    id_emehab numeric(8,0),
    id_tarea numeric(8,0)
);
 #   DROP TABLE public.tarea_habilidad;
       public         heap    postgres    false         �            1259    33247    usuario    TABLE     �   CREATE TABLE public.usuario (
    id integer NOT NULL,
    nombre character varying(255),
    email character varying(255),
    password character varying(255)
);
    DROP TABLE public.usuario;
       public         heap    postgres    false         �            1259    33246    usuario_id_seq    SEQUENCE     �   CREATE SEQUENCE public.usuario_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 %   DROP SEQUENCE public.usuario_id_seq;
       public          postgres    false    225         P           0    0    usuario_id_seq    SEQUENCE OWNED BY     A   ALTER SEQUENCE public.usuario_id_seq OWNED BY public.usuario.id;
          public          postgres    false    224         �            1259    33137    vol_habilidad    TABLE     �   CREATE TABLE public.vol_habilidad (
    id numeric(8,0) NOT NULL,
    id_voluntario numeric(8,0),
    id_habilidad numeric(8,0)
);
 !   DROP TABLE public.vol_habilidad;
       public         heap    postgres    false         �            1259    33140 
   voluntario    TABLE     d   CREATE TABLE public.voluntario (
    id numeric(8,0) NOT NULL,
    nombre character varying(100)
);
    DROP TABLE public.voluntario;
       public         heap    postgres    false         �           2604    33250 
   usuario id    DEFAULT     h   ALTER TABLE ONLY public.usuario ALTER COLUMN id SET DEFAULT nextval('public.usuario_id_seq'::regclass);
 9   ALTER TABLE public.usuario ALTER COLUMN id DROP DEFAULT;
       public          postgres    false    224    225    225         =          0    33109    eme_habilidad 
   TABLE DATA           H   COPY public.eme_habilidad (id, id_emergencia, id_habilidad) FROM stdin;
    public          postgres    false    214       3389.dat >          0    33112 
   emergencia 
   TABLE DATA           X   COPY public.emergencia (id, nombre, descrip, finicio, ffin, id_institucion) FROM stdin;
    public          postgres    false    215       3390.dat ?          0    33117    estado_tarea 
   TABLE DATA           3   COPY public.estado_tarea (id, descrip) FROM stdin;
    public          postgres    false    216       3391.dat @          0    33120 	   habilidad 
   TABLE DATA           0   COPY public.habilidad (id, descrip) FROM stdin;
    public          postgres    false    217       3392.dat A          0    33123    institucion 
   TABLE DATA           :   COPY public.institucion (id, nombre, descrip) FROM stdin;
    public          postgres    false    218       3393.dat B          0    33128    ranking 
   TABLE DATA           d   COPY public.ranking (id, id_voluntario, id_tarea, puntaje, flg_invitado, flg_participa) FROM stdin;
    public          postgres    false    219       3394.dat C          0    33131    tarea 
   TABLE DATA           �   COPY public.tarea (id, nombre, descrip, cant_vol_requeridos, cant_vol_inscritos, id_emergencia, finicio, ffin, id_estado) FROM stdin;
    public          postgres    false    220       3395.dat D          0    33134    tarea_habilidad 
   TABLE DATA           B   COPY public.tarea_habilidad (id, id_emehab, id_tarea) FROM stdin;
    public          postgres    false    221       3396.dat H          0    33247    usuario 
   TABLE DATA           >   COPY public.usuario (id, nombre, email, password) FROM stdin;
    public          postgres    false    225       3400.dat E          0    33137    vol_habilidad 
   TABLE DATA           H   COPY public.vol_habilidad (id, id_voluntario, id_habilidad) FROM stdin;
    public          postgres    false    222       3397.dat F          0    33140 
   voluntario 
   TABLE DATA           0   COPY public.voluntario (id, nombre) FROM stdin;
    public          postgres    false    223       3398.dat Q           0    0    usuario_id_seq    SEQUENCE SET     =   SELECT pg_catalog.setval('public.usuario_id_seq', 1, false);
          public          postgres    false    224         �           2606    33144     eme_habilidad eme_habilidad_pkey 
   CONSTRAINT     ^   ALTER TABLE ONLY public.eme_habilidad
    ADD CONSTRAINT eme_habilidad_pkey PRIMARY KEY (id);
 J   ALTER TABLE ONLY public.eme_habilidad DROP CONSTRAINT eme_habilidad_pkey;
       public            postgres    false    214         �           2606    33146    emergencia emergencia_pkey 
   CONSTRAINT     X   ALTER TABLE ONLY public.emergencia
    ADD CONSTRAINT emergencia_pkey PRIMARY KEY (id);
 D   ALTER TABLE ONLY public.emergencia DROP CONSTRAINT emergencia_pkey;
       public            postgres    false    215         �           2606    33148    estado_tarea estado_tarea_pkey 
   CONSTRAINT     \   ALTER TABLE ONLY public.estado_tarea
    ADD CONSTRAINT estado_tarea_pkey PRIMARY KEY (id);
 H   ALTER TABLE ONLY public.estado_tarea DROP CONSTRAINT estado_tarea_pkey;
       public            postgres    false    216         �           2606    33150    habilidad habilidad_pkey 
   CONSTRAINT     V   ALTER TABLE ONLY public.habilidad
    ADD CONSTRAINT habilidad_pkey PRIMARY KEY (id);
 B   ALTER TABLE ONLY public.habilidad DROP CONSTRAINT habilidad_pkey;
       public            postgres    false    217         �           2606    33152    institucion institucion_pkey 
   CONSTRAINT     Z   ALTER TABLE ONLY public.institucion
    ADD CONSTRAINT institucion_pkey PRIMARY KEY (id);
 F   ALTER TABLE ONLY public.institucion DROP CONSTRAINT institucion_pkey;
       public            postgres    false    218         �           2606    33154    ranking ranking_pkey 
   CONSTRAINT     R   ALTER TABLE ONLY public.ranking
    ADD CONSTRAINT ranking_pkey PRIMARY KEY (id);
 >   ALTER TABLE ONLY public.ranking DROP CONSTRAINT ranking_pkey;
       public            postgres    false    219         �           2606    33156 $   tarea_habilidad tarea_habilidad_pkey 
   CONSTRAINT     b   ALTER TABLE ONLY public.tarea_habilidad
    ADD CONSTRAINT tarea_habilidad_pkey PRIMARY KEY (id);
 N   ALTER TABLE ONLY public.tarea_habilidad DROP CONSTRAINT tarea_habilidad_pkey;
       public            postgres    false    221         �           2606    33158    tarea tarea_pkey 
   CONSTRAINT     N   ALTER TABLE ONLY public.tarea
    ADD CONSTRAINT tarea_pkey PRIMARY KEY (id);
 :   ALTER TABLE ONLY public.tarea DROP CONSTRAINT tarea_pkey;
       public            postgres    false    220         �           2606    33254    usuario usuario_pkey 
   CONSTRAINT     R   ALTER TABLE ONLY public.usuario
    ADD CONSTRAINT usuario_pkey PRIMARY KEY (id);
 >   ALTER TABLE ONLY public.usuario DROP CONSTRAINT usuario_pkey;
       public            postgres    false    225         �           2606    33160     vol_habilidad vol_habilidad_pkey 
   CONSTRAINT     ^   ALTER TABLE ONLY public.vol_habilidad
    ADD CONSTRAINT vol_habilidad_pkey PRIMARY KEY (id);
 J   ALTER TABLE ONLY public.vol_habilidad DROP CONSTRAINT vol_habilidad_pkey;
       public            postgres    false    222         �           2606    33162    voluntario voluntario_pkey 
   CONSTRAINT     X   ALTER TABLE ONLY public.voluntario
    ADD CONSTRAINT voluntario_pkey PRIMARY KEY (id);
 D   ALTER TABLE ONLY public.voluntario DROP CONSTRAINT voluntario_pkey;
       public            postgres    false    223         �           2606    33163 "   eme_habilidad fk_emehab_emergencia    FK CONSTRAINT     �   ALTER TABLE ONLY public.eme_habilidad
    ADD CONSTRAINT fk_emehab_emergencia FOREIGN KEY (id_emergencia) REFERENCES public.emergencia(id);
 L   ALTER TABLE ONLY public.eme_habilidad DROP CONSTRAINT fk_emehab_emergencia;
       public          postgres    false    214    3217    215         �           2606    33168 !   eme_habilidad fk_emehab_habilidad    FK CONSTRAINT     �   ALTER TABLE ONLY public.eme_habilidad
    ADD CONSTRAINT fk_emehab_habilidad FOREIGN KEY (id_habilidad) REFERENCES public.habilidad(id);
 K   ALTER TABLE ONLY public.eme_habilidad DROP CONSTRAINT fk_emehab_habilidad;
       public          postgres    false    3221    217    214         �           2606    33173 $   emergencia fk_emergencia_institucion    FK CONSTRAINT     �   ALTER TABLE ONLY public.emergencia
    ADD CONSTRAINT fk_emergencia_institucion FOREIGN KEY (id_institucion) REFERENCES public.institucion(id);
 N   ALTER TABLE ONLY public.emergencia DROP CONSTRAINT fk_emergencia_institucion;
       public          postgres    false    3223    215    218         �           2606    33178    ranking fk_ranking_tarea    FK CONSTRAINT     x   ALTER TABLE ONLY public.ranking
    ADD CONSTRAINT fk_ranking_tarea FOREIGN KEY (id_tarea) REFERENCES public.tarea(id);
 B   ALTER TABLE ONLY public.ranking DROP CONSTRAINT fk_ranking_tarea;
       public          postgres    false    3227    220    219         �           2606    33183    ranking fk_ranking_voluntario    FK CONSTRAINT     �   ALTER TABLE ONLY public.ranking
    ADD CONSTRAINT fk_ranking_voluntario FOREIGN KEY (id_voluntario) REFERENCES public.voluntario(id);
 G   ALTER TABLE ONLY public.ranking DROP CONSTRAINT fk_ranking_voluntario;
       public          postgres    false    3233    223    219         �           2606    33188    tarea fk_tarea_emergencia    FK CONSTRAINT     �   ALTER TABLE ONLY public.tarea
    ADD CONSTRAINT fk_tarea_emergencia FOREIGN KEY (id_emergencia) REFERENCES public.emergencia(id);
 C   ALTER TABLE ONLY public.tarea DROP CONSTRAINT fk_tarea_emergencia;
       public          postgres    false    215    220    3217         �           2606    33193    tarea fk_tarea_estadotarea    FK CONSTRAINT     �   ALTER TABLE ONLY public.tarea
    ADD CONSTRAINT fk_tarea_estadotarea FOREIGN KEY (id_estado) REFERENCES public.estado_tarea(id);
 D   ALTER TABLE ONLY public.tarea DROP CONSTRAINT fk_tarea_estadotarea;
       public          postgres    false    216    220    3219         �           2606    33198 "   tarea_habilidad fk_tareahab_emehab    FK CONSTRAINT     �   ALTER TABLE ONLY public.tarea_habilidad
    ADD CONSTRAINT fk_tareahab_emehab FOREIGN KEY (id_emehab) REFERENCES public.eme_habilidad(id);
 L   ALTER TABLE ONLY public.tarea_habilidad DROP CONSTRAINT fk_tareahab_emehab;
       public          postgres    false    221    214    3215         �           2606    33203 !   tarea_habilidad fk_tareahab_tarea    FK CONSTRAINT     �   ALTER TABLE ONLY public.tarea_habilidad
    ADD CONSTRAINT fk_tareahab_tarea FOREIGN KEY (id_tarea) REFERENCES public.tarea(id);
 K   ALTER TABLE ONLY public.tarea_habilidad DROP CONSTRAINT fk_tareahab_tarea;
       public          postgres    false    221    220    3227         �           2606    33208 !   vol_habilidad fk_volhab_habilidad    FK CONSTRAINT     �   ALTER TABLE ONLY public.vol_habilidad
    ADD CONSTRAINT fk_volhab_habilidad FOREIGN KEY (id_habilidad) REFERENCES public.habilidad(id);
 K   ALTER TABLE ONLY public.vol_habilidad DROP CONSTRAINT fk_volhab_habilidad;
       public          postgres    false    3221    222    217         �           2606    33213 "   vol_habilidad fk_volhab_voluntario    FK CONSTRAINT     �   ALTER TABLE ONLY public.vol_habilidad
    ADD CONSTRAINT fk_volhab_voluntario FOREIGN KEY (id_voluntario) REFERENCES public.voluntario(id);
 L   ALTER TABLE ONLY public.vol_habilidad DROP CONSTRAINT fk_volhab_voluntario;
       public          postgres    false    3233    222    223                                                                                           3389.dat                                                                                            0000600 0004000 0002000 00000000636 14432544376 0014301 0                                                                                                    ustar 00postgres                        postgres                        0000000 0000000                                                                                                                                                                        1	3	10
2	13	10
3	11	31
4	11	6
5	2	7
6	14	45
7	2	1
8	16	24
9	5	36
10	3	14
11	3	24
12	1	38
13	18	32
14	19	5
15	9	37
16	17	30
17	3	31
18	15	1
19	14	40
20	6	37
21	18	29
22	9	19
23	12	42
24	16	21
25	4	2
26	14	3
27	16	42
28	4	28
29	17	36
30	14	10
31	18	21
32	7	28
33	8	20
34	9	39
35	6	14
36	16	8
37	18	21
38	18	26
39	1	21
40	14	40
41	13	22
42	12	7
43	9	20
44	8	9
45	13	10
46	8	41
47	4	41
48	13	28
49	17	45
50	14	35
\.


                                                                                                  3390.dat                                                                                            0000600 0004000 0002000 00000011004 14432544376 0014260 0                                                                                                    ustar 00postgres                        postgres                        0000000 0000000                                                                                                                                                                        1	in sagittis dui vel nisl duis ac nibh fusce lacus	turpis integer aliquet massa id lobortis convallis tortor risus dapibus augue vel accumsan tellus nisi eu orci mauris lacinia sapien quis libero nullam sit amet turpis elementum ligula vehicula consequat	2019-09-29	2022-01-22	14
2	proin risus praesent lectus vestibulum quam sapien varius ut blandit	in faucibus orci luctus et ultrices posuere cubilia curae donec pharetra magna vestibulum aliquet ultrices erat	2019-12-23	2022-04-04	2
3	sapien quis libero nullam sit amet turpis elementum ligula vehicula	vestibulum vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia curae nulla dapibus dolor vel est donec odio justo sollicitudin ut suscipi	2020-11-01	2022-12-20	7
4	purus aliquet at feugiat non pretium quis lectus	luctus et ultrices posuere cubilia curae nulla dapibus dolor vel est donec odio justo sollicitudin ut suscipit a feugiat et eros vestibulum ac est lacinia nisi venenatis tristique fusce congue diam id ornare	2020-08-30	2022-10-13	18
5	curabitur convallis	orci luctus et ultrices posuere cubilia curae mauris viverra diam vitae	2020-06-14	2022-07-03	20
6	duis bibendum felis sed interdum	orci nullam molestie nibh in lectus pellentesque at nulla suspendisse potenti cras in purus eu magna vulputate	2020-02-13	2022-01-08	12
7	libero convallis eget eleifend	rutrum nulla nunc purus phasellus in felis donec semper sapien a libero nam dui proin leo odio porttitor id consequat in consequat	2020-05-01	2022-05-05	20
8	erat id mauris vulputate	congue diam id ornare imperdiet sapien urna pretium nisl ut volutpat sapien arcu sed augue aliquam erat volutpat in congue etiam justo	2021-05-02	2021-10-29	19
9	velit eu est congue	orci luctus et ultrices posuere cubilia curae nulla dapibus dolor vel est donec odio justo s tristique fusce congue diam id ornare	2020-04-12	2021-08-28	10
10	ut dictumst etiam	sed justo pellentesque viverra pede mpus semper est quam pharetra magna ac consequat metus sapien ut  posuere cubilia curae mauris viverr potenti null donec posuere metus vitae ipsum aliquam non mauris morbi non	2021-05-02	2023-10-02	17
11	in habitasse platea	ipsum integer a nibh in quis justo maecenas  curae mauris viverra diam vitae quam suspendisse potenti nullam porttitor lacus	2020-10-08	2022-11-11	20
12	hac habitasse	rutrum nulla tellus in a odio in hac habitasse platea dictumst maecenas ut massa quis augue luctus tincidunt nulla mollis molestie lorem quisque ut erat placerat praesent blandit nam nulla integer	2021-05-30	2023-01-19	13
13	pretium iaculis	libero nam dui proin leo odio porttitor id consequat in consequat ut nulla sed accumsan felis ut at dolor quis odio consequat varius integer ac leo pellentesque ultrices mattis odio	2021-03-26	2023-01-23	16
14	ante ipsum primis	cubilia curae mauris viverra diam vitae quam suspendisse potenti nullam porttitor lacus at turpis donec posuere metus vitae ipsum aliquam non mauris morbi non lectus aliquam sit amet dia	2019-09-20	2021-11-07	15
15	in hac	justo pellentesque viverra pede ac diam cras pellentesque volutpat dui maecenas tristique est et tempus semper est quam pharetra magna ac consequat metus sapien ut nunc vestibulum ante	2020-09-12	2023-01-29	8
16	libero	consectetuer eget rutrum at lorem integer tincidunt ante vel ipsum praesent blandit lacinia erat vestibulum sed magna at nunc commodo placerat praesent blandit nam nulla integer pede justo lacinia eget tincidunt eget tempus	2020-03-06	2023-03-27	4
17	quis	sapien iaculis congue vivamus metus arcu adipiscing molestie hendrerit at vulputate vitae nisl aenean lectus pellentesque eget nunc donec quis orci eget orci vehicula condimentum curabitur in libero ut massa volutpat convallis morbi odio odio elementum	2019-09-22	2022-07-18	15
18	elementum	sed lacus morbi sem mauris laoreet ut rhoncus aliquet pulvinar sed nisl nunc rhoncus dui vel sem sed sagittis nam congue risus semper porta volutpat quam pede lobortis ligula sit amet eleifend pede libero quis orci nullam molestie	2021-03-22	2022-08-27	4
19	nam dui proin	vestibulum sit amet cursus id turpis integer aliquet massa id lobortis convallis tortor risus dapibus augue vel accumsan tellus nisi eu orci mauris lacinia sapien quis libero nullam sit amet turpis elementum ligula vehicula consequat morbi a ipsum integer	2020-02-15	2022-01-15	1
20	vel nulla eget	ut nunc vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia curae mauris viverra diam vitae quam suspendisse potenti nullam porttitor lacus at turpis donec posuere metus vitae ipsum aliquam non mauris	2020-07-01	2021-12-08	14
\.


                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                            3391.dat                                                                                            0000600 0004000 0002000 00000001355 14432544376 0014271 0                                                                                                    ustar 00postgres                        postgres                        0000000 0000000                                                                                                                                                                        1	id turpis
2	in tempus sit ame
3	at velit vivamus vel
4	sed vestibulum sit
5	pretium iaculis jus
6	sagittis dui vel
7	orci pede venena
8	curae donec
9	justo maecenas
10	dapibus
11	tincidunt
12	molestie lorem
13	molestie sed justo
14	augue a suscipi
15	nibh in quis
16	congue
17	ut at
18	tincidunt
19	non velit
20	metus sapien ut
21	habitasse platea
22	blandit
23	orci luctus
24	at
25	orci luctus et
26	consequat
27	enim sit
28	praesent
29	eget rutrum at lorem
30	magnis diss
31	odio consequat
32	viverra pede
33	eu
34	purus phasellus
35	congue
36	pellentesque
37	quisque porta
38	morbi odio odio
39	eget
40	quam fringilla
41	integer ac
42	vestibulum
43	neque duis
44	dictumst
45	elit ac
46	pulvinar
47	eget
48	amet
49	donec da
50	ipsum primis
\.


                                                                                                                                                                                                                                                                                   3392.dat                                                                                            0000600 0004000 0002000 00000007535 14432544376 0014300 0                                                                                                    ustar 00postgres                        postgres                        0000000 0000000                                                                                                                                                                        1	dictumst etiam faucibus cursus urna ut tellus nulla ut erat id mauris vulputate elementum nullam
2	nulla elit ac nulla sed vel enim sit amet nunc viverra dapibus nulla
3	in quis justo maecenas rhoncus aliquam lacus morbi quis tortor id nulla
4	magna vulputate luctus cum sociis natoque penatibus et magnis dis parturient
5	consequat morbi a ipsum integer a nibh in quis justo maecenas rhoncus aliquam lacus morbi quis
6	dui proin leo odio porttitor id consequat in consequat ut nulla sed accumsan felis ut
7	eu interdum eu tincidunt in leo maecenas pulvinar lobortis est phasellus
8	eu orci mauris lacinia sapien quis libero nullam sit amet turpis elementum ligula
9	fringilla rhoncus mauris enim leo rhoncus sed vestibulum sit amet cursus id turpis integer
10	enim blandit mi in porttitor pede justo eu massa donec dapibus duis at
11	maecenas rhoncus aliquam lacus morbi quis tortor id nulla ultrices aliquet maecenas leo
12	at ipsum ac tellus semper interdum mauris ullamcorper purus sit amet nulla qui
13	fusce lacus purus aliquet at feugiat non pretium quis lectus suspendisse potenti
14	volutpat sapien arcu sed augue aliquam erat volutpat in congue etiam justo etiam pretium
15	rhoncus sed vestibulum sit amet cursus id turpis integer aliquet massa id lobortis
16	nisi vulputate nonummy maecenas tincidunt lacus at velit vivamus vel
17	nulla mollis molestie lorem quisque ut erat curabitur gravida nisi
18	in libero ut massa volutpat convallis morbi odio odio elementum
19	justo lacinia eget tincidunt eget tempus vel pede morbi porttitor lorem id
20	in leo maecenas pulvinar lobortis est phasellus sit amet erat nulla tempus
21	erat id mauris vulputate elementum nullam varius nulla facilisi cras non velit
22	curae mauris viverra diam vitae quam suspendisse potenti nullam porttitor
23	at vulputate vitae nisl aenean lectus pellentesque eget nunc donec quis orci eget orci vehicula
24	ante vivamus tortor duis mattis egestas metus aenean fermentum donec
25	velit id pretium iaculis diam erat fermentum justo nec condimentum neque
26	accumsan felis ut at dolor quis odio consequat varius integer ac leo pellentesque
27	sapien arcu sed augue aliquam erat volutpat in congue etiam justo etiam pr
28	molestie lorem quisque ut erat curabitur gravida nisi at nibh in hac habitass
29	quis turpis sed ante vivamus tortor duis mattis egestas metus aenean fermentum
30	ridiculus mus etiam vel augue vestibulum rutrum rutrum neque aenean auct
31	praesent blandit lacinia erat vestibulum sed magna at nunc commodo placerat
32	orci luctus et ultrices posuere cubilia curae donec pharetra magna vestibulum
33	nullam varius nulla facilisi cras non velit nec nisi vulputate nonummy maecenas
34	posuere metus vitae ipsum aliquam non mauris morbi non lectus aliquam sit amet
35	curabitur convallis duis consequat dui nec nisi volutpat eleifend donec ut dolor
36	amet lobortis sapien sapien non mi integer ac neque duis bibendum morbi
37	justo sit amet sapien dignissim vestibulum vestibulum ante ipsum primis
38	at feugiat non pretium quis lectus suspendisse potenti in eleifend quam
39	id nulla ultrices aliquet maecenas leo odio condimentum id luctus nec molestie
40	vestibulum sit amet cursus id turpis integer aliquet massa id lobortis convallis
41	vivamus metus arcu adipiscing molestie hendrerit at vulputate vitae nisl
42	enim leo rhoncus sed vestibulum sit amet cursus id turpis integer aliquet
43	nulla eget eros elementum pellentesque quisque porta volutpat erat quisque erat
44	porttitor id consequat in consequat ut nulla sed accumsan felis ut at
45	vestibulum proin eu mi nulla ac enim in tempor turpis nec euismod
46	praesent blandit lacinia erat vestibulum sed magna at nunc commodo
47	bibendum imperdiet nullam orci pede venenatis non sodales
48	non mi integer ac neque duis bibendum morbi non quam nec
49	sapien dignissim vestibulum vestibulum ante ipsum primis in
50	cursus id turpis integer aliquet massa id lobortis
\.


                                                                                                                                                                   3393.dat                                                                                            0000600 0004000 0002000 00000013523 14432544376 0014273 0                                                                                                    ustar 00postgres                        postgres                        0000000 0000000                                                                                                                                                                        1	Sula nebouxii	nisl nunc nisl duis bibendum felis sed interdum venenatis turpis enim blandit mi in porttitor pede justo eu massa donec dapibus duis at velit eu est congue elementum in hac habitasse platea dictumst morbi vestibulum velit id pretium iaculis diam erat fermentum justo nec condimentum neque sapien placerat ante nulla justo aliquam quis turpis
2	Lutra canadensis	sed vestibulum sit amet cursus id turpis integer aliquet massa id lobortis convallis tortor risus dapibus augue vel accumsan tellus nisi eu orci mauris lacinia sapien quis libero nullam sit amet turpis elementum ligula vehicula consequat morbi a ipsum integer a nibh in quis justo maecenas rhoncus aliquam lacus morbi quis tortor id
3	Cacatua tenuirostris	id justo sit amet sapien dignissim vestibulum vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia curae nulla dapibus dolor vel est donec odio justo sollicitudin ut suscipit a feugiat et eros vestibulum ac est lacinia nisi venenatis tristique fusce congue diam id ornare imperdiet sapien urna pretium nis
4	Ictonyx striatus	phasellus sit amet erat nulla tempus vivamus in felis eu sapien cursus vestibulum proin eu mi nulla ac enim in tempor turpis nec euismod scelerisque quam turpis adipiscing lorem vitae mattis nibh ligula nec sem duis aliquam convallis nunc proin at turpis a pede posuere nonummy integer non velit donec diam neque
5	Phoenicopterus ruber	venenatis non sodales sed tincidunt eu felis fusce posuere felis sed lacus morbi sem mauris laoreet ut rhoncus aliquet pulvinar sed nisl nunc rhoncus dui vel sem sed sagittis nam congue risus semper porta volutpat quam pede lobortis ligula sit amet eleifend pede libero quis orci
6	Zenaida galapagoensis	rhoncus aliquet pulvinar sed nisl nunc rhoncus dui vel sem sed sagittis nam congue risus semper porta volutpat quam pede lobortis ligula sit amet eleifend pede libero quis orci nullam molestie nibh in lectus pellentesque at nulla suspendisse potenti cras in purus eu magna vulputate luctus cum sociis
7	Phoenicopterus ruber	leo odio porttitor id consequat in consequat ut nulla sed accumsan felis ut at dolor quis odio consequat varius integer ac leo pellentesque ultrices mattis odio donec vitae nisi nam ultrices libero non mattis pulvinar nulla pede ullamcorper augue a suscipit nulla elit ac nulla sed vel enim sit
8	Cabassous sp.	lobortis est phasellus sit amet erat nulla tempus vivamus in felis eu sapien cursus vestibulum proin eu mi nulla ac enim in tempor turpis
9	Zosterops pallidus	bibendum felis sed interdum venenatis turpis enim blandit mi in porttitor pede justo eu massa donec dapibus duis at velit eu est congue elementum in hac habitasse platea dictumst morbi vestibulum velit id pretium iaculis diam erat fermentum justo nec condimentum neque sapien placerat ante nulla justo
10	Felis concolor	felis eu sapien cursus vestibulum proin eu mi nulla ac enim in tempor turpis nec euismod scelerisque quam turpis adipiscing lorem vitae mattis nibh ligula nec sem duis aliquam convallis nunc proin at turpis a pede posuere nonummy integer non
11	Semnopithecus entellus	hac habitasse platea dictumst maecenas ut massa quis augue luctus tincidunt nulla mollis molestie lorem quisque ut erat curabitur gravida nisi at nibh in hac habitasse platea dictumst aliquam augue quam sollicitudin vitae consectetuer eget rutrum at lorem integer tincidun
12	Aonyx capensis	in blandit ultrices enim lorem ipsum dolor sit amet consectetuer adipiscing elit proin interdum mauris non ligula pellentesque ultrices phasellus id sapien in sapien iaculis congue vivamus metus arcu adipiscing molestie hendrerit at vulputate vitae nisl aenean lectus pellentesque eget nunc don
13	Madoqua kirkii	maecenas tincidunt lacus at velit vivamus vel nulla eget eros elementum pellentesque quisque porta volutpat erat quisque erat eros viverra eget congue eget semper rutrum nulla nunc purus phasellus in felis donec semper sapien a libero nam dui proin leo odio porttitor id consequat in consequat
14	Bettongia penicillata	pellentesque quisque porta volutpat erat quisque erat eros viverra eget congue eget semper rutrum nulla nunc purus phasellus in felis donec semper sapien a libero nam dui proin leo odio porttitor id consequat in consequat ut nulla sed accumsan felis ut at dolor quis
15	Macropus rufus	sem praesent id massa id nisl venenatis lacinia aenean sit amet justo morbi ut odio cras mi pede malesuada in imperdiet et commodo vulputate justo in blandit ultrices enim lorem ipsum dolor sit amet consectetuer adipiscing elit proin interdum mauris non ligula pellentesque ultrices phasellus id
16	Ardea golieth	turpis adipiscing lorem vitae mattis nibh ligula nec sem duis aliquam convallis nunc proin at turpis a pede posuere nonummy integer non velit donec diam neque vestibulum eget vulputate ut ultrices vel augue vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia curae d
17	Macropus eugenii	sed ante vivamus tortor duis mattis egestas metus aenean fermentum donec ut mauris eget massa tempor convallis nulla neque libero convallis eget eleifend luctus ultricies eu nibh quisque id justo sit amet sapien dignissim vestibulum vestibulum ante ipsum primis in faucibus orci luctus et ul
18	Motacilla aguimp	feugiat et eros vestibulum ac est lacinia nisi venenatis tristique fusce congue diam id ornare imperdiet sapien urna pretium nisl ut volutpat sapien arcu sed augue aliquam erat volutpat in congue etiam justo etiam pretium iaculis justo in hac habitasse platea dictumst etiam faucibus
19	Larus dominicanus	nullam porttitor lacus at turpis donec posuere metus vitae ipsum aliquam non mauris morbi non lectus aliquam sit amet diam
20	Varanus salvator	pulvinar lobortis est phasellus sit amet erat nulla tempus vivamus in felis eu sapien cursus vestibulum proin eu mi nulla ac enim in tempor turpis nec euismod scelerisque quam turpis adipiscing lorem vitae mattis nibh ligula nec sem duis aliquam convallis nunc
\.


                                                                                                                                                                             3394.dat                                                                                            0000600 0004000 0002000 00000001557 14432544376 0014300 0                                                                                                    ustar 00postgres                        postgres                        0000000 0000000                                                                                                                                                                        1	36	7	4.00	0	0
2	49	35	4.90	1	2
3	8	8	3.00	7	2
4	43	35	5.40	0	1
5	37	47	5.90	2	6
6	9	44	6.40	4	7
7	47	46	5.10	8	3
8	26	47	3.80	4	5
9	28	6	7.50	2	1
10	23	47	7.20	9	5
11	3	25	1.50	9	3
12	50	40	4.80	7	6
13	27	23	4.70	0	5
14	42	6	1.60	7	5
15	37	26	8.10	4	1
16	3	1	9.60	2	5
17	27	3	3.40	2	8
18	25	38	7.30	7	4
19	17	2	4.20	8	9
20	23	44	4.60	9	4
21	22	15	4.60	2	1
22	19	31	6.50	3	7
23	37	3	6.40	1	6
24	34	20	5.10	3	2
25	22	27	9.00	6	9
26	43	41	4.20	9	2
27	31	10	1.00	6	0
28	50	33	8.40	7	4
29	43	37	5.00	5	9
30	27	44	4.20	4	3
31	35	41	6.90	3	2
32	16	19	4.10	5	4
33	20	40	5.00	7	7
34	7	50	4.00	5	1
35	45	23	4.30	2	2
36	40	10	1.00	3	3
37	2	48	9.50	2	2
38	21	23	1.50	3	2
39	7	41	1.30	4	4
40	32	17	7.90	7	6
41	22	3	2.50	1	5
42	38	40	4.00	1	8
43	39	17	6.30	4	5
44	39	42	9.50	6	2
45	36	10	8.10	8	2
46	32	5	9.70	4	9
47	45	20	5.60	5	1
48	46	41	2.30	7	5
49	20	49	4.90	7	2
50	12	13	8.10	7	5
\.


                                                                                                                                                 3395.dat                                                                                            0000600 0004000 0002000 00000012561 14432544376 0014276 0                                                                                                    ustar 00postgres                        postgres                        0000000 0000000                                                                                                                                                                        1	Romeo Mike Quebec X-ray India	egestas metus aenean fermentum donec ut mauris eget massa tempor convallis nulla	15	9	8	2021-01-29	2021-08-11	13
2	Charlie Delta Echo Yankee	sapien	11	7	20	2020-05-24	2022-08-13	49
3	Delta Lima Bravo Yankee Quebec	bibendum felis sed interdum	10	9	15	2021-01-24	2022-12-12	23
4	Papa Kilo Victor Romeo Foxtrot	sociis natoque penatibus et magnis dis parturient montes nascetur ridiculus mus vivamus vestibulum sagittis	14	2	11	2020-05-11	2023-11-01	1
5	Foxtrot Delta Echo	bibendum imperdiet nullam orci pede venenatis non sodales sed tincidunt eu felis fusce posuere	12	8	19	2021-05-23	2022-04-11	29
6	Victor Charlie Lima Echo	lacinia eget tincidunt eget tempus vel pede morbi	14	5	20	2020-09-28	2021-12-26	12
7	Yankee	diam in magna	11	8	2	2021-05-20	2022-03-26	10
8	Zulu Quebec Bravo Tango Alfa	nascetur ridiculus mus etiam vel augue vestibulum	13	6	15	2020-07-10	2021-12-11	39
9	Hotel Uniform	ipsum ac tellus semper interdum mauris ullamcorper purus sit amet nulla quisque arcu libero rutrum	10	9	8	2020-06-27	2023-01-31	10
10	Kilo Charlie	dolor sit amet consectetuer	10	5	2	2020-02-09	2022-07-12	39
11	Hotel Yankee X-ray Oscar	sapien urna pretium nisl ut volutpat sapien arcu	12	1	17	2021-06-28	2022-05-31	24
12	Romeo Sierra Uniform Yankee	fusce posuere felis sed lacus morbi sem mauris laoreet ut rhoncus aliquet pulvinar sed	15	2	6	2020-11-24	2022-03-10	42
13	November Lima Hotel	eget orci vehicula condimentum curabitur in libero ut massa volutpat convallis morbi odio odio	12	8	3	2020-09-06	2022-12-21	14
14	Tango November Kilo	magnis dis parturient	12	1	19	2021-04-17	2023-04-01	37
15	Hotel	sit amet justo	10	8	11	2020-09-10	2022-04-20	14
16	India Sierra X-ray	aliquet at feugiat non pretium quis lectus	12	7	8	2020-12-15	2022-06-12	18
17	Bravo Oscar India Zulu	congue eget semper rutrum nulla nunc purus phasellus in felis	12	3	11	2021-04-30	2021-12-13	14
18	Zulu Alfa X-ray Victor	pellentesque quisque porta volutpat erat	12	6	12	2021-06-24	2023-03-02	24
19	India Whiskey	potenti in eleifend quam a odio	10	5	2	2020-05-28	2022-10-04	41
20	Kilo Quebec Mike Yankee	odio justo sollicitudin ut suscipit a feugiat et eros	15	6	10	2020-11-21	2023-04-23	10
21	India X-ray Zulu	tristique in tempus sit amet sem fusce consequat nulla nisl	13	6	14	2020-03-06	2023-02-17	44
22	India	nunc donec quis orci eget orci vehicula condimentum curabitur in libero ut massa volutpat	15	5	19	2021-04-22	2021-12-16	43
23	Yankee Golf Papa Zulu	sem fusce consequat nulla nisl nunc	10	5	15	2020-10-29	2023-02-22	7
24	India Yankee	at	10	4	13	2020-04-19	2021-12-23	4
25	November Uniform Oscar Mike	eget tempus vel	12	9	14	2020-12-07	2023-01-23	18
26	Echo	sagittis nam congue risus semper porta volutpat quam pede lobortis	15	7	6	2021-05-03	2021-09-17	47
27	Quebec Oscar	ultrices aliquet maecenas leo odio condimentum id luctus nec molestie sed justo pellentesque viverra	14	10	17	2021-04-03	2022-05-20	22
28	Mike Delta	nunc donec quis orci eget orci vehicula	11	4	8	2020-12-10	2021-11-21	28
29	India Kilo X-ray Uniform Tango	potenti in	11	6	20	2020-08-18	2021-10-28	48
30	Uniform Alfa India Golf	justo nec condimentum neque sapien placerat ante	13	4	1	2021-03-15	2023-09-03	3
31	Yankee Kilo	amet nunc viverra dapibus nulla suscipit ligula in lacus curabitur at ipsum ac	13	6	19	2020-02-11	2023-02-25	43
32	Sierra Foxtrot Echo Oscar India	sit amet nulla quisque arcu libero rutrum ac lobortis vel dapibus	12	4	13	2020-11-16	2022-05-02	22
33	X-ray Mike Sierra Bravo	quis tortor id nulla ultrices aliquet maecenas leo odio condimentum	14	9	19	2020-04-16	2023-08-02	12
34	Sierra Romeo Lima Echo	faucibus orci luctus	11	10	15	2021-04-18	2021-08-13	41
35	Zulu	quis turpis eget elit sodales scelerisque mauris sit	14	5	13	2021-06-06	2022-09-06	40
36	Oscar Kilo	habitasse platea dictumst aliquam augue quam sollicitudin vitae consectetuer eget rutrum at lorem integer	14	6	18	2021-03-16	2022-09-30	30
37	Yankee Victor	ut massa quis augue luctus tincidunt nulla mollis molestie	14	2	2	2021-01-19	2021-05-08	26
38	Romeo Tango	est quam pharetra magna ac consequat metus sapien ut nunc vestibulum ante ipsum	14	9	19	2021-11-04	2022-09-07	16
39	Uniform	commodo	13	5	5	2020-12-15	2022-04-25	22
40	Yankee Victor Juliett Echo	porttitor id	10	5	3	2020-04-21	2022-06-14	1
41	Charlie	faucibus orci luctus et ultrices posuere cubilia curae duis faucibus accumsan odio	10	6	14	2020-11-03	2023-03-23	7
42	Foxtrot	rutrum nulla tellus in sagittis dui vel nisl duis ac nibh fusce	12	5	3	2021-01-31	2023-01-23	49
43	Quebec	nam ultrices libero non mattis pulvinar nulla pede ullamcorper augue a suscipit nulla elit ac	15	9	4	2020-02-23	2022-09-04	4
44	Golf Zulu Charlie Uniform Foxtrot	nullam varius nulla facilisi cras non velit nec nisi vulputate nonummy maecenas tincidunt lacus	11	7	9	2020-04-15	2023-03-29	30
45	Golf Romeo Delta	porttitor lorem id ligula suspendisse ornare consequat lectus in est	14	9	14	2021-03-27	2022-03-07	45
46	Romeo Foxtrot Yankee Bravo	ipsum primis in faucibus orci luctus et ultrices	15	8	18	2021-05-19	2022-11-28	9
47	Delta Juliett Hotel Tango	venenatis turpis enim blandit mi in porttitor pede justo eu massa donec dapibus	11	8	16	2020-07-30	2023-02-25	4
48	Uniform X-ray	justo etiam	10	4	9	2021-09-05	2022-08-23	39
49	Uniform Delta Golf Sierra	id justo sit amet sapien dignissim vestibulum vestibulum ante ipsum primis in faucibus orci	14	1	19	2021-01-04	2023-04-17	41
50	Kilo Whiskey	aliquet maecenas leo odio condimentum id luctus	15	3	17	2021-04-01	2022-01-24	17
\.


                                                                                                                                               3396.dat                                                                                            0000600 0004000 0002000 00000000660 14432544376 0014274 0                                                                                                    ustar 00postgres                        postgres                        0000000 0000000                                                                                                                                                                        1	13	12
2	9	30
3	50	37
4	7	5
5	36	28
6	49	15
7	21	50
8	26	21
9	23	14
10	24	14
11	31	13
12	18	28
13	30	12
14	1	39
15	45	9
16	4	10
17	33	43
18	4	37
19	26	24
20	16	37
21	37	39
22	28	39
23	11	5
24	25	1
25	29	16
26	29	5
27	25	38
28	3	49
29	22	35
30	29	25
31	11	27
32	37	13
33	24	44
34	42	15
35	29	14
36	12	48
37	36	15
38	18	45
39	44	43
40	29	5
41	36	30
42	22	37
43	11	36
44	30	32
45	1	47
46	25	31
47	22	13
48	9	42
49	44	23
50	36	43
\.


                                                                                3400.dat                                                                                            0000600 0004000 0002000 00000000142 14432544376 0014251 0                                                                                                    ustar 00postgres                        postgres                        0000000 0000000                                                                                                                                                                        1	Adler Dunmuir	adler@gmail.com	$2a$10$q47CMovY.qzTbS5mOP6/zuptvY7clgyiJaVD4o0JFMnFdlqRfPyAi
\.


                                                                                                                                                                                                                                                                                                                                                                                                                              3397.dat                                                                                            0000600 0004000 0002000 00000001536 14432544376 0014300 0                                                                                                    ustar 00postgres                        postgres                        0000000 0000000                                                                                                                                                                        1	27	30
2	24	46
3	22	50
4	19	14
5	27	11
6	12	11
7	44	15
8	30	10
9	27	40
10	6	23
11	7	9
12	36	9
13	37	6
14	39	3
15	44	9
16	37	18
17	30	37
18	47	30
19	47	21
20	24	45
21	13	6
22	21	19
23	19	37
24	21	47
25	22	41
26	22	15
27	39	30
28	46	49
29	1	16
30	36	11
31	1	12
32	19	16
33	13	20
34	8	18
35	22	17
36	1	50
37	7	40
38	28	9
39	7	47
40	35	22
41	29	35
42	9	40
43	20	25
44	47	46
45	26	49
46	42	2
47	30	5
48	22	14
49	6	36
50	16	32
51	40	15
52	47	7
53	5	34
54	45	26
55	24	10
56	11	9
57	47	10
58	16	20
59	4	26
60	37	28
61	47	8
62	38	22
63	30	25
64	45	41
65	42	35
66	16	39
67	18	22
68	22	22
69	50	6
70	50	37
71	29	39
72	49	15
73	37	10
74	5	20
75	10	23
76	32	29
77	39	38
78	13	43
79	10	32
80	41	12
81	10	42
82	17	44
83	13	6
84	26	30
85	36	42
86	2	27
87	38	43
88	47	2
89	47	37
90	3	7
91	37	43
92	5	15
93	8	44
94	30	46
95	20	7
96	47	22
97	49	10
98	20	29
99	37	12
100	6	28
\.


                                                                                                                                                                  3398.dat                                                                                            0000600 0004000 0002000 00000001556 14432544376 0014303 0                                                                                                    ustar 00postgres                        postgres                        0000000 0000000                                                                                                                                                                        1	Adler Dunmuir
2	Rosalia Hawkes
3	Rafaela Hurrell
4	May Goodoune
5	Dannie Cutchey
6	Aristotle Marti
7	Silvanus Hainge
8	Zollie McNeilley
9	Nadya Dobbison
10	Dody Wearn
11	Lionello Espina
12	Geri Squibe
13	Meade MacLardie
14	Alfredo Lesser
15	John Allam
16	Emeline Satch
17	Stewart Nind
18	Dara Ravenshear
19	Florry Hargess
20	Englebert Jee
21	Nicolle Punchard
22	Mattie Sorrell
23	Morry Housbey
24	Edik Cadogan
25	Kenneth Bricket
26	Murielle Sieve
27	Bendick Venour
28	Rogerio Brodnecke
29	Britt Dall
30	Harwilll Furniss
31	Agosto Viner
32	Vanessa Hallworth
33	Mindy Cow
34	Debora Polon
35	Cesaro Klimochkin
36	Maryellen MacIlhagga
37	Darrel Jurries
38	Shelton Danilchev
39	Neal Topping
40	Hallie Malshinger
41	Hamish Tyrer
42	Lev Grzeszczak
43	Korrie Arton
44	Veda Seary
45	Judi Basek
46	Janel Edler
47	Linnet Dinnies
48	Charyl Peasegod
49	Lorita Dench
50	Briano Molfino
\.


                                                                                                                                                  restore.sql                                                                                         0000600 0004000 0002000 00000031055 14432544376 0015404 0                                                                                                    ustar 00postgres                        postgres                        0000000 0000000                                                                                                                                                                        --
-- NOTE:
--
-- File paths need to be edited. Search for $$PATH$$ and
-- replace it with the path to the directory containing
-- the extracted data files.
--
--
-- PostgreSQL database dump
--

-- Dumped from database version 15.2
-- Dumped by pg_dump version 15.2

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

DROP DATABASE "SistemaVoluntariado";
--
-- Name: SistemaVoluntariado; Type: DATABASE; Schema: -; Owner: postgres
--

CREATE DATABASE "SistemaVoluntariado" WITH TEMPLATE = template0 ENCODING = 'UTF8' LOCALE_PROVIDER = libc LOCALE = 'Spanish_Mexico.1252';


ALTER DATABASE "SistemaVoluntariado" OWNER TO postgres;

\connect "SistemaVoluntariado"

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

SET default_tablespace = '';

SET default_table_access_method = heap;

--
-- Name: eme_habilidad; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.eme_habilidad (
    id numeric(8,0) NOT NULL,
    id_emergencia numeric(6,0),
    id_habilidad numeric(4,0)
);


ALTER TABLE public.eme_habilidad OWNER TO postgres;

--
-- Name: emergencia; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.emergencia (
    id numeric(6,0) NOT NULL,
    nombre character varying(100),
    descrip character varying(400),
    finicio date,
    ffin date,
    id_institucion numeric(4,0)
);


ALTER TABLE public.emergencia OWNER TO postgres;

--
-- Name: estado_tarea; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.estado_tarea (
    id numeric(2,0) NOT NULL,
    descrip character varying(20)
);


ALTER TABLE public.estado_tarea OWNER TO postgres;

--
-- Name: habilidad; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.habilidad (
    id numeric(4,0) NOT NULL,
    descrip character varying(100)
);


ALTER TABLE public.habilidad OWNER TO postgres;

--
-- Name: institucion; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.institucion (
    id numeric(4,0) NOT NULL,
    nombre character varying(100),
    descrip character varying(400)
);


ALTER TABLE public.institucion OWNER TO postgres;

--
-- Name: ranking; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.ranking (
    id numeric(8,0) NOT NULL,
    id_voluntario numeric(8,0),
    id_tarea numeric(8,0),
    puntaje numeric(3,2),
    flg_invitado numeric(1,0),
    flg_participa numeric(1,0)
);


ALTER TABLE public.ranking OWNER TO postgres;

--
-- Name: TABLE ranking; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON TABLE public.ranking IS 'los flgInvitado, flgParticipa 1 si la respuesta es si, 2 si la respuesta es no';


--
-- Name: tarea; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.tarea (
    id numeric(8,0) NOT NULL,
    nombre character varying(60),
    descrip character varying(300),
    cant_vol_requeridos numeric(4,0),
    cant_vol_inscritos numeric(4,0),
    id_emergencia numeric(6,0),
    finicio date,
    ffin date,
    id_estado numeric(2,0)
);


ALTER TABLE public.tarea OWNER TO postgres;

--
-- Name: tarea_habilidad; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.tarea_habilidad (
    id numeric(8,0) NOT NULL,
    id_emehab numeric(8,0),
    id_tarea numeric(8,0)
);


ALTER TABLE public.tarea_habilidad OWNER TO postgres;

--
-- Name: usuario; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.usuario (
    id integer NOT NULL,
    nombre character varying(255),
    email character varying(255),
    password character varying(255)
);


ALTER TABLE public.usuario OWNER TO postgres;

--
-- Name: usuario_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.usuario_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.usuario_id_seq OWNER TO postgres;

--
-- Name: usuario_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.usuario_id_seq OWNED BY public.usuario.id;


--
-- Name: vol_habilidad; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.vol_habilidad (
    id numeric(8,0) NOT NULL,
    id_voluntario numeric(8,0),
    id_habilidad numeric(8,0)
);


ALTER TABLE public.vol_habilidad OWNER TO postgres;

--
-- Name: voluntario; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.voluntario (
    id numeric(8,0) NOT NULL,
    nombre character varying(100)
);


ALTER TABLE public.voluntario OWNER TO postgres;

--
-- Name: usuario id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.usuario ALTER COLUMN id SET DEFAULT nextval('public.usuario_id_seq'::regclass);


--
-- Data for Name: eme_habilidad; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.eme_habilidad (id, id_emergencia, id_habilidad) FROM stdin;
\.
COPY public.eme_habilidad (id, id_emergencia, id_habilidad) FROM '$$PATH$$/3389.dat';

--
-- Data for Name: emergencia; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.emergencia (id, nombre, descrip, finicio, ffin, id_institucion) FROM stdin;
\.
COPY public.emergencia (id, nombre, descrip, finicio, ffin, id_institucion) FROM '$$PATH$$/3390.dat';

--
-- Data for Name: estado_tarea; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.estado_tarea (id, descrip) FROM stdin;
\.
COPY public.estado_tarea (id, descrip) FROM '$$PATH$$/3391.dat';

--
-- Data for Name: habilidad; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.habilidad (id, descrip) FROM stdin;
\.
COPY public.habilidad (id, descrip) FROM '$$PATH$$/3392.dat';

--
-- Data for Name: institucion; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.institucion (id, nombre, descrip) FROM stdin;
\.
COPY public.institucion (id, nombre, descrip) FROM '$$PATH$$/3393.dat';

--
-- Data for Name: ranking; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.ranking (id, id_voluntario, id_tarea, puntaje, flg_invitado, flg_participa) FROM stdin;
\.
COPY public.ranking (id, id_voluntario, id_tarea, puntaje, flg_invitado, flg_participa) FROM '$$PATH$$/3394.dat';

--
-- Data for Name: tarea; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.tarea (id, nombre, descrip, cant_vol_requeridos, cant_vol_inscritos, id_emergencia, finicio, ffin, id_estado) FROM stdin;
\.
COPY public.tarea (id, nombre, descrip, cant_vol_requeridos, cant_vol_inscritos, id_emergencia, finicio, ffin, id_estado) FROM '$$PATH$$/3395.dat';

--
-- Data for Name: tarea_habilidad; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.tarea_habilidad (id, id_emehab, id_tarea) FROM stdin;
\.
COPY public.tarea_habilidad (id, id_emehab, id_tarea) FROM '$$PATH$$/3396.dat';

--
-- Data for Name: usuario; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.usuario (id, nombre, email, password) FROM stdin;
\.
COPY public.usuario (id, nombre, email, password) FROM '$$PATH$$/3400.dat';

--
-- Data for Name: vol_habilidad; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.vol_habilidad (id, id_voluntario, id_habilidad) FROM stdin;
\.
COPY public.vol_habilidad (id, id_voluntario, id_habilidad) FROM '$$PATH$$/3397.dat';

--
-- Data for Name: voluntario; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.voluntario (id, nombre) FROM stdin;
\.
COPY public.voluntario (id, nombre) FROM '$$PATH$$/3398.dat';

--
-- Name: usuario_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.usuario_id_seq', 1, false);


--
-- Name: eme_habilidad eme_habilidad_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.eme_habilidad
    ADD CONSTRAINT eme_habilidad_pkey PRIMARY KEY (id);


--
-- Name: emergencia emergencia_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.emergencia
    ADD CONSTRAINT emergencia_pkey PRIMARY KEY (id);


--
-- Name: estado_tarea estado_tarea_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.estado_tarea
    ADD CONSTRAINT estado_tarea_pkey PRIMARY KEY (id);


--
-- Name: habilidad habilidad_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.habilidad
    ADD CONSTRAINT habilidad_pkey PRIMARY KEY (id);


--
-- Name: institucion institucion_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.institucion
    ADD CONSTRAINT institucion_pkey PRIMARY KEY (id);


--
-- Name: ranking ranking_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.ranking
    ADD CONSTRAINT ranking_pkey PRIMARY KEY (id);


--
-- Name: tarea_habilidad tarea_habilidad_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.tarea_habilidad
    ADD CONSTRAINT tarea_habilidad_pkey PRIMARY KEY (id);


--
-- Name: tarea tarea_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.tarea
    ADD CONSTRAINT tarea_pkey PRIMARY KEY (id);


--
-- Name: usuario usuario_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.usuario
    ADD CONSTRAINT usuario_pkey PRIMARY KEY (id);


--
-- Name: vol_habilidad vol_habilidad_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.vol_habilidad
    ADD CONSTRAINT vol_habilidad_pkey PRIMARY KEY (id);


--
-- Name: voluntario voluntario_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.voluntario
    ADD CONSTRAINT voluntario_pkey PRIMARY KEY (id);


--
-- Name: eme_habilidad fk_emehab_emergencia; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.eme_habilidad
    ADD CONSTRAINT fk_emehab_emergencia FOREIGN KEY (id_emergencia) REFERENCES public.emergencia(id);


--
-- Name: eme_habilidad fk_emehab_habilidad; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.eme_habilidad
    ADD CONSTRAINT fk_emehab_habilidad FOREIGN KEY (id_habilidad) REFERENCES public.habilidad(id);


--
-- Name: emergencia fk_emergencia_institucion; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.emergencia
    ADD CONSTRAINT fk_emergencia_institucion FOREIGN KEY (id_institucion) REFERENCES public.institucion(id);


--
-- Name: ranking fk_ranking_tarea; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.ranking
    ADD CONSTRAINT fk_ranking_tarea FOREIGN KEY (id_tarea) REFERENCES public.tarea(id);


--
-- Name: ranking fk_ranking_voluntario; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.ranking
    ADD CONSTRAINT fk_ranking_voluntario FOREIGN KEY (id_voluntario) REFERENCES public.voluntario(id);


--
-- Name: tarea fk_tarea_emergencia; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.tarea
    ADD CONSTRAINT fk_tarea_emergencia FOREIGN KEY (id_emergencia) REFERENCES public.emergencia(id);


--
-- Name: tarea fk_tarea_estadotarea; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.tarea
    ADD CONSTRAINT fk_tarea_estadotarea FOREIGN KEY (id_estado) REFERENCES public.estado_tarea(id);


--
-- Name: tarea_habilidad fk_tareahab_emehab; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.tarea_habilidad
    ADD CONSTRAINT fk_tareahab_emehab FOREIGN KEY (id_emehab) REFERENCES public.eme_habilidad(id);


--
-- Name: tarea_habilidad fk_tareahab_tarea; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.tarea_habilidad
    ADD CONSTRAINT fk_tareahab_tarea FOREIGN KEY (id_tarea) REFERENCES public.tarea(id);


--
-- Name: vol_habilidad fk_volhab_habilidad; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.vol_habilidad
    ADD CONSTRAINT fk_volhab_habilidad FOREIGN KEY (id_habilidad) REFERENCES public.habilidad(id);


--
-- Name: vol_habilidad fk_volhab_voluntario; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.vol_habilidad
    ADD CONSTRAINT fk_volhab_voluntario FOREIGN KEY (id_voluntario) REFERENCES public.voluntario(id);


--
-- PostgreSQL database dump complete
--

                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                   