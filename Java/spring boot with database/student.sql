PGDMP     &                    w            postgres #   10.6 (Ubuntu 10.6-0ubuntu0.18.04.1) #   10.6 (Ubuntu 10.6-0ubuntu0.18.04.1) 
    �           0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                       false            �           0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                       false            �           0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                       false            �            1259    70059    student    TABLE     �   CREATE TABLE public.student (
    email character varying(255),
    firstname character varying(255),
    lastname character varying(255),
    mobile character varying(255),
    id integer NOT NULL
);
    DROP TABLE public.student;
       public         postgres    false            �            1259    70082    student_id_seq    SEQUENCE     �   CREATE SEQUENCE public.student_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 %   DROP SEQUENCE public.student_id_seq;
       public       postgres    false    234            �           0    0    student_id_seq    SEQUENCE OWNED BY     A   ALTER SEQUENCE public.student_id_seq OWNED BY public.student.id;
            public       postgres    false    236            N           2604    70084 
   student id    DEFAULT     h   ALTER TABLE ONLY public.student ALTER COLUMN id SET DEFAULT nextval('public.student_id_seq'::regclass);
 9   ALTER TABLE public.student ALTER COLUMN id DROP DEFAULT;
       public       postgres    false    236    234            �          0    70059    student 
   TABLE DATA               I   COPY public.student (email, firstname, lastname, mobile, id) FROM stdin;
    public       postgres    false    234   �	       �           0    0    student_id_seq    SEQUENCE SET     <   SELECT pg_catalog.setval('public.student_id_seq', 1, true);
            public       postgres    false    236            P           2606    70092    student student_pkey 
   CONSTRAINT     R   ALTER TABLE ONLY public.student
    ADD CONSTRAINT student_pkey PRIMARY KEY (id);
 >   ALTER TABLE ONLY public.student DROP CONSTRAINT student_pkey;
       public         postgres    false    234            �   5   x��+H,I�qH,J/-�O+����,J�� �rZ��Z�pr��qqq ��v     